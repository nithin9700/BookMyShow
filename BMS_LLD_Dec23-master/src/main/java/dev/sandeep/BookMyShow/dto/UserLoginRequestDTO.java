package dev.sandeep.BookMyShow.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDTO {
    private String Email;
    private String password;
}
