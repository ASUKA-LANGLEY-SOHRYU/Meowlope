package com.prosvirnin.authservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
    private Long id;
    private String email;
    private String username;
}
