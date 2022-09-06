package com.bridgelabz.bookstore.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CartDTO {
    private Integer userID;
    private Integer bookID;
    @NotNull(message="Book quantity yet to be provided")
    private Integer quantity;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
