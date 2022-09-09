package com.bridgelabz.bookstore.entity;

import com.bridgelabz.bookstore.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="UserDetails")
public class User {
    @Id
    @GeneratedValue
    private Integer userID;
    private  String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;



    public User(UserDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.password = dto.getPassword();

    }
    public User(Integer userID,UserDTO dto) {
        this.userID=userID;
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.password = dto.getPassword();

    }

}
