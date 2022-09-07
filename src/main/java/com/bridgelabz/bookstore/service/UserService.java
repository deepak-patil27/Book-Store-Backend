package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.repository.UserRepository;
import com.bridgelabz.bookstore.util.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    EmailSenderService mailService;

    //Ability to serve controller's insert user record api call
    public User registerUser(UserDTO userdto) {
        User newUser = new User(userdto);
        mailService.sendEmail(userdto.getEmail(),"User got registered","Hello: You Have Successfully Added New User");
        return  userRepo.save(newUser);
    }

    public List<User> getAllRecords(){
        List<User> 	userList = userRepo.findAll();
        log.info("All Record Retrieved Successfully");
        return userList;
    }
    //Ability to serve controller's retrieve user record by id api call
    public User getRecord(Integer id){
        Optional<User> 	user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        }
        else {
            log.info("Record retrieved successfully for id "+id);
            return user.get();
        }
    }
    public User updateRecord(Integer id, UserDTO dto) {
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        }
        else {
            User newUser = new User(id,dto);
            userRepo.save(newUser);
            log.info("User data updated successfully");
            return newUser;
        }
    }
}
