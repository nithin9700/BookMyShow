package dev.sandeep.BookMyShow.exception;

public class ActorNotFoundException extends Exception{
    public ActorNotFoundException() {
    }

    public ActorNotFoundException(String message) {
        super(message);
    }
}
