package com.rest.repository;

import com.rest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    @Query(value="SELECT DISTINCT location FROM customer;", nativeQuery=true)
    List<String> findDistinctLocation();

    @Query(value="SELECT  lastname, discount FROM customer WHERE location='Нижегородский';", nativeQuery=true)
    List<String> findNizh();


}
