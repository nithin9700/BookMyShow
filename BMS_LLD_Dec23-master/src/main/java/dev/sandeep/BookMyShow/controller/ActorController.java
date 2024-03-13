package dev.sandeep.BookMyShow.controller;

import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    @Autowired
    private ActorService actorService;

}
