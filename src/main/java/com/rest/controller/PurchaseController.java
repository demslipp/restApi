package com.rest.controller;

import com.rest.model.Purchase;
import com.rest.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController{

    private PurchaseService purchaseService;

    @RequestMapping(value="/savePurchase", method=RequestMethod.POST)
    @ResponseStatus(code=HttpStatus.CREATED)
    public void savePurchase(@RequestBody Purchase purchase){
        purchaseService.save(purchase);
    }

    @GetMapping("/findPurchase")
    public ResponseEntity<Purchase> findById(@RequestParam int id){
        Purchase purchase=purchaseService.findById(id);
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/findAllPurchase")
    public ResponseEntity<List<Purchase>> findAllPurchases(){
        List<Purchase> result=purchaseService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deletePurchase/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable int id){
        purchaseService.deleteById(id);
    }

    @PutMapping("/replacePurchase/{id}")
    public ResponseEntity<Purchase> replacePurchase(@RequestBody Purchase purchase, @PathVariable Integer id){
        Purchase replacedPurchase=purchaseService.replacePurchase(purchase, id);
        return ResponseEntity.ok(replacedPurchase);
    }

    @GetMapping("/PurchaseDate")
    public ResponseEntity<List<String>> PurchaseDate(){
        List<String> purchase=purchaseService.PurchaseDate();
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/FindCustomerShop")
    public ResponseEntity<List<String>> FindCustomerShop(){
        List<String> purchase=purchaseService.FindCustomerShop();
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/findFullPurchase")
    public ResponseEntity<List<String>> findFullPurchase(){
        List<String> purchase=purchaseService.findFullPurchase();
        return ResponseEntity.ok(purchase);
    }


    @GetMapping("/findPurchaseCustomerDate")
    public ResponseEntity<List<String>> findPurchaseCustomerDate(){
        List<String> purchase=purchaseService.findPurchaseCustomerDate();
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/findSortedPurchase")
    public ResponseEntity<List<String>> findSortedPurchase(){
        List<String> purchase=purchaseService.findSortedPurchase();
        return ResponseEntity.ok(purchase);
    }

    @GetMapping("/findPurchaseSum")
    public ResponseEntity<List<String>> findPurchaseSum(){
        List<String> purchase=purchaseService.findPurchaseSum();
        return ResponseEntity.ok(purchase);
    }
}
