package dev.sandeep.BookMyShow.dto;

public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
    }

    public UserNotExistException(String message) {
        super(message);
    }
}
