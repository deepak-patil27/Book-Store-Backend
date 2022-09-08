package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;

import java.util.List;

public interface IUserService {
    public String registerUser(UserDTO userdto);
    public String getToken(String email);
    public List<User> getAllRecords();

    public User getRecord(Integer id);

    public User getRecordByToken(String token);

    public User updateRecord(Integer id, UserDTO dto);
}
