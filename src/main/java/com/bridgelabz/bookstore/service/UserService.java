package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;
import com.bridgelabz.bookstore.exception.BookStoreException;
import com.bridgelabz.bookstore.repository.UserRepository;
import com.bridgelabz.bookstore.util.EmailSenderService;
import com.bridgelabz.bookstore.util.TokenUtil;
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

    @Autowired
    TokenUtil util;

    //Ability to serve controller's insert user record api call
    public String registerUser(UserDTO userdto) {
        User newUser = new User(userdto);
        userRepo.save(newUser);
        String token = util.createToken(newUser.getUserID());
        mailService.sendEmail(userdto.getEmail(),"Account Sign-up successfully","Hello" + newUser.getFirstName() + " Your Account has been created.Your token is " + token + " Keep this token safe to access your account in future ");
        return token;
    }
    //Ability to serve controller's retrieve user record by token api call
    public User getRecordByToken(String token){
        Integer id = util.decodeToken(token);
        Optional<User> 	user = userRepo.findById(id);
        if(user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        }
        else {
            log.info("Record retrieved successfully for given token having id "+id);
            return user.get();
        }
    }
    //Ability to serve controller's get token for changing password api call
    public String getToken(String email) {
        Optional<User> user = userRepo.findByMail(email);
        String token = util.createToken(user.get().getUserID());
        log.info("Token sent on mail successfully");
        return token;
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
