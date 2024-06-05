package com.api.bluetrip.controllers.dtos.user;

import com.api.bluetrip.models.User;

import java.time.LocalDateTime;

public record DetailedUserDTO(
        String email,
        LocalDateTime createdAt,
        String userType
) {
    public DetailedUserDTO(User user) {
        this(user.getEmail(), user.getCreatedAt(), user.getUserType());
    }
}
