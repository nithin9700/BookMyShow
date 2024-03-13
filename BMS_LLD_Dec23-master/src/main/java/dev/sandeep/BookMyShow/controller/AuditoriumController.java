package dev.sandeep.BookMyShow.controller;

import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;

}
