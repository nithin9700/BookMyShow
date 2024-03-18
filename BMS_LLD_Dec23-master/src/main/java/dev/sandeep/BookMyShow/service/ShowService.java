package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.model.*;
import dev.sandeep.BookMyShow.model.constant.PaymentMode;
import dev.sandeep.BookMyShow.model.constant.PaymentStatus;
import dev.sandeep.BookMyShow.repository.CityRepository;
import dev.sandeep.BookMyShow.repository.MovieRepository;
import dev.sandeep.BookMyShow.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieService movieService;


    public Show getShowById(int paymentId){
        return showRepository.findById(paymentId).get();
    }
    public Show saveShow(Auditorium auditorium, String movie, LocalDateTime dateTime){
        Show show = new Show();
        show.setAuditorium(auditorium);
        show.setMovie(movieService.findMovie(movie));
        show.setStartTime(dateTime);
        show.setEndTime(dateTime.plusMinutes(180));
        return showRepository.save(show);
    }

    public Show saveShow(Show show){
        return showRepository.save(show);
    }

    public boolean deleteShow(int showId){
        showRepository.deleteById(showId);
        return true;
    }
}
