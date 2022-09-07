package com.bridgelabz.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private Integer cartID;
    @OneToOne
    @JoinColumn(name="userID")
    private User user;
    @OneToOne
    @JoinColumn(name="bookID")
    private Book book;
    private Integer quantity;

    public Cart(Integer cartID,Integer quantity, Book book, User user) {
        this.cartID= cartID;
        this.quantity = quantity;
        this.book=book;
        this.user=user;
    }
    public Cart(Integer quantity, Book book, User user) {
        this.quantity = quantity;
        this.book=book;
        this.user=user;
    }
}
