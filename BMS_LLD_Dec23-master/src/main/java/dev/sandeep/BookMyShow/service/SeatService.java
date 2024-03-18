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
    public void createSeat(String seatNumber){
        Seat seat = new Seat();
        seat.setSeatNumber(seatNumber);
        seat.setSeatType(seat.getSeatType());
        seat.setStatus(seat.getStatus());
    }
    public Seat findMovie(String seatNumber){
        return seatRepository.findSeatBySeatNumber(seatNumber);
    }
}
