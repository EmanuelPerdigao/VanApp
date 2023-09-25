package org.vanApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vanApp.dto.LoginDto;
import org.vanApp.dto.UserDto;
import org.vanApp.entity.User;
import org.vanApp.repository.UserRepository;
import org.vanApp.response.LoginResponse;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDto userDto) {

        User user = new User(
                userDto.getId(),
                userDto.getname(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword())
        );
        userRepository.save(user);
        return user.getName();

    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {

        String msg = "";
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<User> employee = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }

    }
}
