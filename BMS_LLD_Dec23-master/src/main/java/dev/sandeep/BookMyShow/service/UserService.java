package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.repository.CityRepository;
import dev.sandeep.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
