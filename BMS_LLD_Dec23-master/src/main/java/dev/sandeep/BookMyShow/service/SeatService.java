package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.model.Seat;
import dev.sandeep.BookMyShow.model.constant.SeatStatus;
import dev.sandeep.BookMyShow.model.constant.SeatType;
import dev.sandeep.BookMyShow.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    private SeatService seatService;
    public void createMovie(String seatNumber, SeatType seatType, SeatStatus seatStatus){
        Seat seat = new Seat();
        seat.setSeatNumber(seatNumber);
        seat.setSeatType(seatType);
        seat.setStatus(seatStatus);
    }
    public Seat findMovie(String seatNumber){
        return seatRepository.findSeatByName(seatNumber);
    }
}
