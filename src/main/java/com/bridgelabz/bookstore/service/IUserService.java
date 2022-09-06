package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;

import java.util.List;

public interface IUserService {
    public User saveDataToRepo(UserDTO userDTO);
    public List<User> getAllRecords();

    public User getRecord(Integer id);

    public User updateRecord(Integer id, UserDTO dto);
}
