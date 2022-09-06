package com.bridgelabz.bookstore.entity;

import com.bridgelabz.bookstore.dto.BookDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue
    private Integer bookID;
    private String bookName;
    private String authorName;
    private Integer price;
    private Integer quantity;

    public Book(BookDTO dto) {
        super();
        this.bookName = dto.getBookName();
        this.authorName = dto.getAuthorName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }
    public Book(Integer bookID,BookDTO dto) {
        super();
        this.bookID = bookID;
        this.bookName = dto.getBookName();
        this.authorName = dto.getAuthorName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
    }
    public Book() {
        super();
    }
}
