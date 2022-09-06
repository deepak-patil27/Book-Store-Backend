package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserDTO;
import com.bridgelabz.bookstore.entity.User;
import com.bridgelabz.bookstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/userdetails")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/createuserdetail")
    public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO("User Record created successfully", userService.saveDataToRepo(userDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/retrieveAll")
    public ResponseEntity<ResponseDTO> getAllRecords(){
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !",userService.getAllRecords());
        return new ResponseEntity(dto, HttpStatus.OK);
    }
    //Ability to call api to retrieve user record by id
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<ResponseDTO> getRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !",userService.getRecord(id));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecord(@PathVariable Integer id, @Valid @RequestBody UserDTO userdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully !",userService.updateRecord(id,userdto));
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }
}
