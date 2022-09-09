package com.bridgelabz.bookstore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ChangePasswordDTO {
    private String email;
    private String newPassword;
    private String token;

}
