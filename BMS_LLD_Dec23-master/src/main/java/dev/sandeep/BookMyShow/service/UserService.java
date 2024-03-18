package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.dto.UserNotExistException;
import dev.sandeep.BookMyShow.exception.PasswordInvalid;
import dev.sandeep.BookMyShow.exception.UserExistException;
import dev.sandeep.BookMyShow.model.BaseModel;
import dev.sandeep.BookMyShow.model.Ticket;
import dev.sandeep.BookMyShow.model.User;
import dev.sandeep.BookMyShow.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User getUserById(int userId){
        return userRepository.findById(userId).get();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email, String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null){
            throw new UserExistException("User with same email exists");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Ticket> ticketList =  new ArrayList<>();
        user.setTickets(ticketList);
        return userRepository.save(user);
    }


    public User logIn(String email, String password){
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new UserNotExistException("Please create an account");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, user.getPassword())){
            return user;
        }
        throw new PasswordInvalid("please enter the correct password");
    }



    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void addTicket(Ticket ticket, int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        optionalUser.ifPresent(user -> {
            List<Ticket> ticketList = user.getTickets();
            ticketList.add(ticket);
            user.setTickets(ticketList);
            saveUser(user);
        });
    }


    public boolean deleteUser(int userId){
        userRepository.deleteById(userId);
        return true;
    }
}
