package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.repository.ActorRepository;
import dev.sandeep.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;
}
