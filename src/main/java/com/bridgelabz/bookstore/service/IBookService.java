package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public Book insertBook(BookDTO bookdto);

    public List<Book> getAllBookRecords();

    public List<Book> getBookRecord(Integer id);

    public Book updateBookRecord(Integer id, BookDTO dto);

    public List<Book> getRecordByBookName(String bookName);

    public Book deleteBookRecord(Integer id);
    public List<Book> sortRecordDesc();

    public List<Book> sortRecordAsc();

    public Book updateQuantity(Integer id, Integer quantity);


}
