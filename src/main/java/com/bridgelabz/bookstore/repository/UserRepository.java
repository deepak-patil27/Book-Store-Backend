package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {



}
