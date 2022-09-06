package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.CartDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cartdetails")
public class CartController {
    //Autowired ICartService to inject its dependency here
    @Autowired
    private ICartService cartService;

    //Ability to call api to insert all cart records
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertBook(@Valid @RequestBody CartDTO cartdto){
        ResponseDTO dto = new ResponseDTO("User registered successfully !",cartService.insertCart(cartdto));
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }
    //Ability to call api to retrieve all card records
    @GetMapping("/retrieveAllCarts")
    public ResponseEntity<ResponseDTO> getAllCartRecords(){
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !",cartService.getAllCartRecords());
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //Ability to call api to retrieve cart record by id
    @GetMapping("/retrieveCart/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !",cartService.getCartRecord(id));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    //Ability to call api to update cart by id
    @PutMapping("/updateCart/{id}")
    public ResponseEntity<ResponseDTO> updateCartRecord(@PathVariable Integer id,@Valid @RequestBody CartDTO cartdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully !",updateCartRecord(id,cartdto));
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }
    //Ability to call api to delete cart by id
    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<ResponseDTO> deleteCartRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record deleted successfully !", cartService.deleteCartRecord(id));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

}
