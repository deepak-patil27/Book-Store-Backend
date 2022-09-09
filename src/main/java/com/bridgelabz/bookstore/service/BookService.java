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
        log.info("Book record inserted successfully");
        return bookRepo.save(newBook);
    }
    public List<Book> getAllBookRecords(){
        List<Book> 	bookList =bookRepo.findAll();
        log.info("All book records retrieved successfully");
        return bookList;
    }
    //Ability to serve to controller's retrieving all records api call
    public Optional<Book> getBookRecord(Integer id) {
        Optional<Book> book = bookRepo.findById(id);
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
            Book newBook = new Book(dto);
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
    //Ability to serve to controller's sort all records in ascending order api call
    public List<Book> sortRecordAsc(){
        List<Book> listOfBooks = bookRepo.sortBooksAsc();
        log.info("Book records sorted in ascending order by price successfully");
        return listOfBooks;
    }
    //Ability to serve to controller's sort all records in descending order api call
    public List<Book> sortRecordDesc(){
        List<Book> listOfBooks = bookRepo.sortBooksDesc();
        log.info("Book records sorted in descending order by price successfully");
        return listOfBooks;
    }
    //Ability to serve to controller's update book quantity api call
    public Book updateQuantity(Integer id, Integer quantity) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()) {
            throw new BookStoreException("Book Record doesn't exists");
        }
        else {
            book.get().setQuantity(quantity);
            bookRepo.save(book.get());
            log.info("Quantity for book record updated successfully for id "+id);
            return book.get();
        }
    }
}
