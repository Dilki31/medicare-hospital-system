package com.dilki.medicare.dto;
import com.dilki.medicare.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String fullName;
    private Role role;
}