package dev.sandeep.BookMyShow.service;

import dev.sandeep.BookMyShow.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
}
