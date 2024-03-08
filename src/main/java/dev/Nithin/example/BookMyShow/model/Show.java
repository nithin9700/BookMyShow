package dev.Nithin.example.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.ref.PhantomReference;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "show_details")
public class Show extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private  Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany
    List<ShowSeat> showSeats;
}
