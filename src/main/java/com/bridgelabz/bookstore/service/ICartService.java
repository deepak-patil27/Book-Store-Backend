package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.entity.Cart;
import lombok.Data;

import java.util.List;

public interface ICartService {
    public Cart insertCart(CartDTO cartdto);

    public List<Cart> getAllCartRecords();

    public Cart getCartRecord(Integer id);

    public Cart updateCartRecord(Integer id, CartDTO dto);

    public Cart deleteCartRecord(Integer id);
}
