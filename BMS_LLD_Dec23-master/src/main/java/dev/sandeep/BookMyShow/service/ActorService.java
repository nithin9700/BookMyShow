package dev.sandeep.BookMyShow.service;

import dev.sandeep.BookMyShow.model.Actor;
import dev.sandeep.BookMyShow.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public void createActor(String name){
        Actor actor = new Actor();
        actor.setName(name);
        actorRepository.save(actor);
    }
}
