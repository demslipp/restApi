package com.rest.repository;

import com.rest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT DISTINCT name, price FROM book;", nativeQuery = true)
    List<String> findDistinctName();

    @Query(value = "SELECT name, price FROM book b WHERE b.name LIKE '%Windows%' OR b.price>20000 " +
            "ORDER BY b.name ASC, b.price DESC;", nativeQuery = true)
    List<String> findNamePrice();

}
