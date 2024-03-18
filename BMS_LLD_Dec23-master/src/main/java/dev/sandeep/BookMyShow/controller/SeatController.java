package dev.sandeep.BookMyShow.controller;


import dev.sandeep.BookMyShow.dto.SeatRequestDTO;
import dev.sandeep.BookMyShow.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {
    @Autowired
    private SeatService seatService;

    private ResponseEntity createSeat(@RequestBody SeatRequestDTO seatRequestDTO){
        seatService.createSeat(seatRequestDTO.getSeatNumber());
        return ResponseEntity.ok("Seat created");
    }

}
