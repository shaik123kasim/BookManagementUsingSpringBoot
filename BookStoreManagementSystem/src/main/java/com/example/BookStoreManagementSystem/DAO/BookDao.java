package com.example.BookStoreManagementSystem.DAO;

import com.example.BookStoreManagementSystem.DTO.BookManagement;
import com.example.BookStoreManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;


@Repository
public class BookDao {
    @Autowired
    BookRepository repository;

    //to insert a book
    public BookManagement addBook(BookManagement book){
        return repository.save(book);

    }
   //to get all books
    public List<BookManagement> getAllBooks(){
        return repository.findAll();
    }
    //to retrieve one book
    public BookManagement getBookById(int id){
        Optional<BookManagement> opt = repository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        else return null;
    }
    // to update a book
    public String updateBook(int id ,String title,String publisher,Double price,int quantity){
        BookManagement book = getBookById(id);
        if(book !=null){
            book.setTitle(title);
            book.setPublisher(publisher);
            book.setPrice(price);
            book.setQuantity(quantity);
            repository.save(book);
            return "Book Updated Successfully";
        }
        else return "Book not found..cannot update !!";
    }
    // delete a book by id
    public String deleteByBookId(int id){
        BookManagement book = getBookById(id);
        if(book != null){
            repository.delete(book);
            return "Book Deleted Successfully..";
        }
        else return "Book Not Found..!";
    }
    //  to get book by title
    public List<BookManagement> getAllTitle(String title){
        return repository.findBookByTitle(title);
    }
    public List<BookManagement> getBookPriceMoreThen(){
        return repository.booksGreaterPrice();
    }

}
