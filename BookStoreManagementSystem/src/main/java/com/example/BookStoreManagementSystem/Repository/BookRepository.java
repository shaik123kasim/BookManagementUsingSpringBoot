package com.example.BookStoreManagementSystem.Repository;

import com.example.BookStoreManagementSystem.DTO.BookManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository  extends JpaRepository<BookManagement, Integer> {

        //to select book by title
        @Query("select book from BookManagement book where book.title = :title")
        public List<BookManagement> findBookByTitle(@Param("title") String title);

        //to get book price > 150
        @Query("select book from BookManagement book where book.price > 150")
        public List<BookManagement> booksGreaterPrice();
}
