package dev.sandeep.BookMyShow.controller;

import dev.sandeep.BookMyShow.dto.ActorRequestDTO;
import dev.sandeep.BookMyShow.exception.ActorNotFoundException;
import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    @Autowired
    private ActorService actorService;

    @PostMapping("/actor")
    public ResponseEntity<String> createActor(@RequestBody ActorRequestDTO actorRequestDTO){
        String name = actorRequestDTO.getName();
        try {
            if (name == null || name.isEmpty() || name.isBlank()) {
                throw new ActorNotFoundException("Add the actor name correctly");
            }else {
                actorService.createActor(name);
            }
            return ResponseEntity.ok("Add actor successfully");
        }
        catch (ActorNotFoundException a){
            a.printStackTrace();
        }
        return ResponseEntity.ofNullable("Failed to add actor to system");
    }

}
