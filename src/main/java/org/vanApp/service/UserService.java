package org.vanApp.service;

import org.vanApp.dto.LoginDto;
import org.vanApp.dto.UserDto;
import org.vanApp.entity.User;
import org.vanApp.response.LoginResponse;

import java.util.Optional;

public interface UserService {

    String addUser(UserDto userDto);
    LoginResponse loginUser(LoginDto loginDto);
}
