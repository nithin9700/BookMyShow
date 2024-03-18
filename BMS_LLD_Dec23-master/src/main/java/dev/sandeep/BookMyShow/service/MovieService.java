package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.model.Movie;
import dev.sandeep.BookMyShow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public void createMovie(String name, String description){
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(description);
        movieRepository.save(movie);
    }
    public Movie findMovie(String movieName){
        return movieRepository.findMovieByName(movieName);
    }
}
