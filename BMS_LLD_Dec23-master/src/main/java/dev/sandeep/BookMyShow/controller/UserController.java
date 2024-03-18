package dev.sandeep.BookMyShow.controller;


import dev.sandeep.BookMyShow.dto.UserSignUpRequestDTO;
import dev.sandeep.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup (@RequestBody UserSignUpRequestDTO userRequestDTO){
        userService.signUp(userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.getPassword());
        return ResponseEntity.ok("User account is successfully created");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserSignUpRequestDTO userRequestDTO){
        userService.logIn(userRequestDTO.getEmail(), userRequestDTO.getPassword());
        return ResponseEntity.ok("login Successfully");
    }
}

