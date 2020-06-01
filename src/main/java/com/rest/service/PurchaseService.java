package com.rest.service;

import com.rest.model.Purchase;
import com.rest.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    public Purchase findById(int id) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        return optionalPurchase.orElse(null);
    }

    public Purchase replacePurchase(Purchase newPurchase, Integer id) {
        return purchaseRepository.findById(id)
                .map(purchase -> {
                    purchase.setDate(newPurchase.getDate());
                    purchase.setSeller(newPurchase.getSeller());
                    purchase.setCustomerId(newPurchase.getCustomerId());
                    purchase.setBookId(newPurchase.getBookId());
                    purchase.setNumber(newPurchase.getNumber());
                    purchase.setSum(newPurchase.getSum());
                    return purchaseRepository.save(purchase);
                })
                .orElseGet(() -> {
                    newPurchase.setId(id);
                    return purchaseRepository.save(newPurchase);
                });
    }
    public void deleteById( int id) {
        purchaseRepository.deleteById(id);
    }


    public List<String> PurchaseDate() {
        return purchaseRepository.PurchaseDate();
    }

    public List<String> FindCustomerShop() {
        return purchaseRepository.FindCustomerShop();
    }

    public List<String> findFullPurchase() {
        return purchaseRepository.findFullPurchase();
    }

    public List<String> findPurchaseCustomerDate() {
        return purchaseRepository.findPurchaseCustomerDate();
    }

    public List<String> findSortedPurchase() {
        return purchaseRepository.findSortedPurchase();
    }

    public List<String> findPurchaseSum() {
        return purchaseRepository.findPurchaseSum();
    }



}