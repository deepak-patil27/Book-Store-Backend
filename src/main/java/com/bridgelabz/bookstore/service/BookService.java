package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.entity.Book;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService implements IBookService{
    @Autowired
    private BookRepository bookRepo;
    public Book insertBook(BookDTO bookdto) {
        Book newBook = new Book(bookdto);
        bookRepo.save(newBook);
        log.info("Book record inserted successfully");
        return newBook;
    }
    public List<Book> getAllBookRecords(){
        List<Book> 	bookList =bookRepo.findAll();
        log.info("All book records retrieved successfully");
        return bookList;
    }
    //Ability to serve to controller's retrieving all records api call
    public List<Book> getBookRecord(Integer id) {
        List<Book> book = bookRepo.findByBookId(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            log.info("Book record retrieved successfully for id "+id);
            return book;
        }
    }
    //Ability to serve to controller's update record by id api call
    public Book updateBookRecord(Integer id,BookDTO dto) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            Book newBook = new Book(id,dto);
            bookRepo.save(newBook);
            log.info("Book record updated successfully for id "+id);
            return newBook;
        }

    }
    public List<Book> getRecordByBookName(String bookName) {
        List<Book> book = bookRepo.findByBookName(bookName);
        if(book.isEmpty()) {
            throw new BookStoreException("Book doesn't exists");
        }
        else {
            log.info("Book record retrieved successfully for Book Name : "+bookName);
            return book;
        }
    }
    //Ability to serve to controller's delete record api call
    public Book deleteBookRecord(Integer id) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            bookRepo.deleteById(id);
            log.info("Book record deleted successfully for id "+id);
            return book.get();
        }
    }
}