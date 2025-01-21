package com.prosvirnin.authservice.mapper;

import com.prosvirnin.authservice.model.domain.user.AuthUser;
import com.prosvirnin.authservice.model.dto.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class AuthUserToUserInfoMapper implements Mapper<AuthUser, UserInfo> {
    @Override
    public UserInfo map(AuthUser user) {
        return UserInfo.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
