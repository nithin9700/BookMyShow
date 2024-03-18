package dev.sandeep.BookMyShow.service;

import dev.sandeep.BookMyShow.model.Show;
import dev.sandeep.BookMyShow.model.ShowSeat;
import dev.sandeep.BookMyShow.model.Ticket;
import dev.sandeep.BookMyShow.model.constant.ShowSeatStatus;
import dev.sandeep.BookMyShow.model.constant.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowSeatService showSeatService;
    private UserService userService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        // checking if the selected seats are available
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new Exception("Seat is not available anymore");
            }
        }
        // updating the seats to a locked state
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
        Ticket ticket = startPayment(showSeatIds);
        userService.addTicket(ticket, userId);
        return ticket;
    }


    public Ticket startPayment(List<Integer> showSeatIds){
        List<ShowSeat> showSeats = new ArrayList<>();
        int total = 0;
        for(int showSeatId : showSeatIds){
            ShowSeat seat = showSeatService.getShowSeat(showSeatId);
            total += seat.getPrice();
            seat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeats.add(seat);
            showSeatService.saveShowSeat(seat);
        }
        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        ticket.setShow(showSeatService.getShow(showSeatIds.get(0)));
        ticket.setTicketStatus(TicketStatus.BOOKED);
        ticket.setTimeOfBooking(LocalDateTime.now());
        ticket.setTotalAmount(total);
        return ticket;
    }

}
