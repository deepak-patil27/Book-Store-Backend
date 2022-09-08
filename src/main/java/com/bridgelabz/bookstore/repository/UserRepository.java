package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="select * from user_details where email =:mail",nativeQuery = true)
    public Optional<User> findByMail(String mail);



}
