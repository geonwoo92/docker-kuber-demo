package com.example.demo.user.service;


import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;

import java.util.Optional;

public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    default User dtoToEntity(UserDto dto) {

        return User.builder().build();
    }

    default UserDto entityToDto(Optional<User> optional) {

        return UserDto.builder().build();

    }
}
