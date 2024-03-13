package dev.sandeep.BookMyShow.controller;


import dev.sandeep.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

}
