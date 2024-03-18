package dev.sandeep.BookMyShow.controller;


import dev.sandeep.BookMyShow.dto.ActorRequestDTO;
import dev.sandeep.BookMyShow.dto.MovieRequestDTO;
import dev.sandeep.BookMyShow.exception.ActorNotFoundException;
import dev.sandeep.BookMyShow.exception.MovieNotFoundException;
import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<String> createMovie(@RequestBody MovieRequestDTO movieRequestDTO){
        String name = movieRequestDTO.getMovieName();
        String  description = movieRequestDTO.getDescription();
        try {
            if (name == null || name.isEmpty() || name.isBlank()) {
                throw new MovieNotFoundException("Add the movie name correctly");
            }else {
                movieService.createMovie(name, description);
            }
            return ResponseEntity.ok("Add Movie successfully");
        }
        catch (MovieNotFoundException a){
            a.printStackTrace();
        }
        return ResponseEntity.ofNullable("Failed to add actor to system");
    }

}
