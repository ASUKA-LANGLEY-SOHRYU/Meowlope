package com.prosvirnin.userservice.model.dto;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String email;
    private String username;
}
