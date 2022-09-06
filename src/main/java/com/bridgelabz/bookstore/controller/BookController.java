package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.BookDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//Controller class to make api calls
@CrossOrigin
@RestController
@RequestMapping("/bookdetails")
public class BookController {
    @Autowired
    private IBookService bookService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertBook(@Valid @RequestBody BookDTO bookdto){
        ResponseDTO dto = new ResponseDTO("User registered successfully !",bookService.insertBook(bookdto));
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }
    @GetMapping("/retrieveBook/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !",bookService.getBookRecord(id));
        return new ResponseEntity(dto,HttpStatus.OK);
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<ResponseDTO> updateBookRecord(@PathVariable Integer id,@Valid @RequestBody BookDTO bookdto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully !",bookService.updateBookRecord(id,bookdto));
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<ResponseDTO> deleteBookRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record deleted successfully !",bookService.deleteBookRecord(id));
        return new ResponseEntity(dto,HttpStatus.ACCEPTED);
    }

}
