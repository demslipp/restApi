package com.rest.repository;

import com.rest.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query(value = "SELECT DISTINCT Extract(MONTH from date ) FROM purchase;", nativeQuery = true)
    List<String> PurchaseDate();


    @Query(value = "SELECT c.lastname, s.name FROM purchase p JOIN customer c ON p.customerId=c.id" +
            " JOIN shop s ON s.id=p.seller;", nativeQuery = true)
    List<String> FindCustomerShop();


    @Query(value = "SELECT p.date, c.lastname, c.discount, b.name, p.number FROM purchase p JOIN customer c ON p.customerId=c.id" +
            " JOIN shop s ON s.id=p.seller " +
            "JOIN book b ON p.bookId=b.id;", nativeQuery = true)
    List<String> findFullPurchase();


    @Query(value = "SELECT p.id, c.lastname, p.date FROM purchase p JOIN customer c ON p.customerId=c.id " +
            " JOIN shop s ON s.id=p.seller" +
            " WHERE p.sum> 60000;", nativeQuery = true)
    List<String> findPurchaseCustomerDate();


    @Query(value = "SELECT c.lastname, c.location, p.date FROM purchase p JOIN customer c ON p.customerId=c.id " +
            " JOIN shop s ON s.id=p.seller" +
            " WHERE s.area=c.location AND  Extract(MONTH from date)>02" +
            " ORDER BY c.lastname, c.location, p.date;", nativeQuery = true)
    List<String> findSortedPurchase();


    @Query(value = "SELECT b.name, b.storage, p.number, p.sum FROM purchase p JOIN customer c ON p.customerId=c.id " +
            " JOIN shop s ON s.id=p.seller" +
            " JOIN book b ON p.bookId=b.id" +
            " WHERE s.area=b.storage AND b.number>10" +
            " ORDER BY p.sum;", nativeQuery = true)
    List<String> findPurchaseSum();

}