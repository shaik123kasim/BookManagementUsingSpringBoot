package com.example.BookStoreManagementSystem.controller;

import com.example.BookStoreManagementSystem.DAO.BookDao;
import com.example.BookStoreManagementSystem.DTO.BookManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookContoller {
    @Autowired
    BookDao bookDao;

    //Rest API to insert book
    @PostMapping("/books")
    public BookManagement insertBook(@RequestBody BookManagement book){
        return bookDao.addBook(book);
    }
    //Rest API to get all books
    @GetMapping("/allBooks")
    public List<BookManagement> getAllBooks(){
        return bookDao.getAllBooks();

    }
    //Rest API to get book by ID
    @GetMapping("/getBook")
    public BookManagement findBookById(@RequestParam int id){
        return bookDao.getBookById(id);

    }
    //Rest API to update book
    @PutMapping("/books")
    public String updateTask(@RequestParam int id , @RequestParam String title,@RequestParam String publisher,@RequestParam Double price,@RequestParam int quantity){
        return bookDao.updateBook(id,title,publisher,price,quantity);
    }
    //Rest API to delete a book
    @DeleteMapping("/books")
    public String deleteById(@RequestParam int id){
        return bookDao.deleteByBookId(id);
    }
    //Rest API to get book by Title
    @GetMapping("/bookTitle")
    public List<BookManagement> getAllByTitle(@RequestParam String title){
        return bookDao.getAllTitle(title);

    }
    //Rest API to get book  price > 150
    @GetMapping("/bookPrice")
    public List<BookManagement> getAllBooksPrice(){
        return bookDao.getBookPriceMoreThen();
    }
}
