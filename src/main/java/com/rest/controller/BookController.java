package com.rest.controller;

import com.rest.model.Book;
import com.rest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController{

    private BookService bookService;

    @RequestMapping(value="/saveBook", method=RequestMethod.POST)
    @ResponseStatus(code=HttpStatus.CREATED)
    public void saveBook(@RequestBody Book book){
        bookService.save(book);
    }

    @GetMapping("/findBook")
    public ResponseEntity<Book> findById(@RequestParam int id){
        Book book=bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/findAllBook")
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> allBooks=bookService.findAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @DeleteMapping("/deleteBook/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id){
        bookService.deleteById(id);

    }

    @PutMapping("/replaceBook/{id}")
    public ResponseEntity<Book> replaceBook(@RequestBody Book book, @PathVariable Integer id){
        Book replacedBook=bookService.replaceBook(book, id);
        return ResponseEntity.ok(replacedBook);

    }

    @GetMapping("/findDistinctName")
    public ResponseEntity<List<String>> findDistinctName(){
        List<String> books=bookService.findDistinctName();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/findNamePrice")
    public ResponseEntity<List<String>> findNamePrice(){
        List<String> books=bookService.findNamePrice();
        return ResponseEntity.ok(books);
    }
}
