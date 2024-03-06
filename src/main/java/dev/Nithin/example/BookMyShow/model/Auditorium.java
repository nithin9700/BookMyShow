package dev.Nithin.example.BookMyShow.model;


import dev.Nithin.example.BookMyShow.model.constant.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<AuditoriumFeature> auditoriumFeatures;


}
