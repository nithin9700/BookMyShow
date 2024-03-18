package dev.sandeep.BookMyShow.exception;

public class PasswordInvalid extends  RuntimeException{
    public PasswordInvalid() {
    }

    public PasswordInvalid(String message) {
        super(message);
    }
}
