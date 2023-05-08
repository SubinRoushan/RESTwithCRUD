package com.rest.api.book.requestingrestapi.controller;

import com.rest.api.book.requestingrestapi.entities.Book;
import com.rest.api.book.requestingrestapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerBook {
    @Autowired
    private BookService bookService;
    @GetMapping("/book")

    //For All Book(GET)
    public List<Book> getbook()
    {
        return this.bookService.getAllBook();
    }

    //For Single Book(GET)

    @GetMapping("/book/{id}")
    public Book getbookbyeid(@PathVariable("id") int id)
    {
        return this.bookService.getBookById(id);
    }



    //Post Mapping
    @PostMapping("/book")
    public Book getBook(@RequestBody Book book)
    {
        return this.bookService.getbookpost(book);
    }



    //DELETE Mapping
    @DeleteMapping("/book/{bookId}")
    public void getdelete(@PathVariable("bookId") int bookId)
    {
        this.bookService.delete(bookId);
    }


    //PUT Mapping
    @PutMapping("/book/{bookId}")
    public Book getupdate(@RequestBody Book book,@PathVariable("bookId") int bookId)
    {
        this.bookService.updateBook(book,bookId);
        return book;
    }


}
