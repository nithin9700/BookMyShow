package dev.Nithin.example.BookMyShow.model;

import dev.Nithin.example.BookMyShow.model.constant.MovieType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    private double duration;
    @ManyToMany
    private List<Actors> Actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieType> movieType;

}
