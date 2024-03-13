package dev.sandeep.BookMyShow.controller;


import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

}
