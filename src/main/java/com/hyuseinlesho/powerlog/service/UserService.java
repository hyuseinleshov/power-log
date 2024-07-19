package com.hyuseinlesho.powerlog.service;

import com.hyuseinlesho.powerlog.model.dto.UserProfileDto;
import com.hyuseinlesho.powerlog.model.entity.UserEntity;

public interface UserService {

    UserEntity getByUsername(String username);

    UserEntity getByEmail(String email);

    boolean changeEmail(String newEmail);

    boolean changePassword(String oldPassword, String newPassword);

    UserProfileDto getCurrentUserDto();

    UserEntity getCurrentUser();
}
