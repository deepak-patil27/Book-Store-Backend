package com.bridgelabz.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

//Order Model with fields
@Entity
@Data
@NoArgsConstructor
@Table(name="OrderDetails")
public class Order {
    @Id
    @GeneratedValue
    private Integer orderID;
    private LocalDate date = LocalDate.now();
    private Integer price;
    private Integer quantity;
    private String address;
    @OneToOne
    @JoinColumn(name="userID")
    private User user;
    @OneToOne
    @JoinColumn(name="bookID")
    private Book book;
    private boolean cancel;

    public Order(Integer orderID,Integer price, Integer quantity, String address, Book book, User user, boolean cancel) {
        this.orderID = orderID;
        this.price=price;
        this.quantity=quantity;
        this.address=address;
        this.book = book;
        this.user=user;
        this.cancel = cancel;
    }

    public Order(Integer price, Integer quantity, String address, Book book, User user, boolean cancel) {
        this.price=price;
        this.quantity=quantity;
        this.address=address;
        this.book = book;
        this.user=user;
        this.cancel = cancel;
    }
}
