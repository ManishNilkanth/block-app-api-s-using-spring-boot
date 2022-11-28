package com.manishCreation.blogappapi.s.Services;

import com.manishCreation.blogappapi.s.Payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long userId);
    List<UserDto> getAllUser();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto ,Long userId);
    void deleteUserById(Long userId);
}
