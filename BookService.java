package com.rest.api.book.requestingrestapi.services;

import com.rest.api.book.requestingrestapi.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    static public List<Book> list=new ArrayList<>();
    static {
        list.add(new Book(1,"Java","Mr.Subin"));
        list.add(new Book(2,"SQL","Mr.Jay"));
        list.add(new Book(3,"Python","Mr.Raj"));
    }

    //Method for All Book
    public List<Book> getAllBook()
    {
        return list;
    }


    //Method for single Book
    public Book getBookById(int id)
    {
        Book book=new Book();
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //Method for Post
    public Book getbookpost(Book b)
    {
        list.add(b);
        return b;
    }

    //Method for DELETE
    public void delete(int d)
    {
        list.stream().filter(e->e.getId()!=d).collect(Collectors.toList());
    }


    //Methof for PUT
    public void updateBook(Book b,int bookId)
    {
        list= list.stream().map(e->{
             if(e.getId()==bookId)
             {
                 e.setTitle(b.getTitle());
                 e.setAuthor(b.getAuthor());

             }
             return e;
         }).collect(Collectors.toList());
    }
}
