package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value="select * from cart where bookid =:bookId",nativeQuery =true)
    Optional<Cart> findByBookId(Integer bookId);

    @Query(value="select * from cart where userid =:userId",nativeQuery =true)
    List<Cart> findByUserId(Integer userId);

    @Query(value="select * from cart where userid =:userId and bookid =:bookId",nativeQuery =true)
    List<Cart> findByUserAndBookId(Integer userId, Integer bookId);

    @Query(value="select * from cart where userid =:userID",nativeQuery =true)
    Optional<Cart> findByUserID(Integer userID);
}
