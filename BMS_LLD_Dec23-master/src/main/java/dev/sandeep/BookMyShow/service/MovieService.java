package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.repository.CityRepository;
import dev.sandeep.BookMyShow.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
}
