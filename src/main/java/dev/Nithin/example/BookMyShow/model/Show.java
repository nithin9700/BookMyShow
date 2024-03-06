package dev.Nithin.example.BookMyShow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.lang.ref.PhantomReference;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @Column(name = "START_TIME")
    private LocalDateTime startTime;
    @Column(name = "END_TIME")
    private LocalDateTime endTime;
    @ManyToOne
    private  Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    List<ShowSeat> showSeats;

}
