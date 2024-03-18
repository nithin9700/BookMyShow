package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.model.Auditorium;
import dev.sandeep.BookMyShow.model.Show;
import dev.sandeep.BookMyShow.model.Ticket;
import dev.sandeep.BookMyShow.model.User;
import dev.sandeep.BookMyShow.repository.CityRepository;
import dev.sandeep.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId){
        return userRepository.findById(userId).get();
    }
    public User saveUser(String name,Ticket ticket, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        List<Ticket> ticketList = user.getTickets() == null ? new ArrayList<>() : user.getTickets();
        ticketList.add(ticket);
        user.setTickets(ticketList);
        return userRepository.save(user);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public boolean deleteUser(int userId){
        userRepository.deleteById(userId);
        return true;
    }
}
