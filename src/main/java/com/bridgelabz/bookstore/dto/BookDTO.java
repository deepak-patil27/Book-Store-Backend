package com.bridgelabz.bookstore.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookDTO {
    @NotEmpty(message="Please enter book name")
    private String bookName;
    @NotEmpty(message="Please enter author name")
    private String authorName;
    private Integer price;
    private Integer quantity;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
