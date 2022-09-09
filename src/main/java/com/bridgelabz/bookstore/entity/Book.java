package com.bridgelabz.bookstore.entity;

import com.bridgelabz.bookstore.dto.BookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Integer bookID;
    private String bookName;
    private String authorName;
    private Integer price;
    private Integer quantity;
    private String bookDescription;
    private String bookImg;

    public Book(BookDTO dto) {
        this.bookName = dto.getBookName();
        this.authorName = dto.getAuthorName();
        this.price = dto.getPrice();
        this.quantity = dto.getQuantity();
        this.bookDescription = dto.getBookDescription();
        this.bookImg = dto.getBookImg();
    }

}
