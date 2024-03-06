package dev.Nithin.example.BookMyShow.model;

import com.fasterxml.jackson.core.Base64Variant;
import dev.Nithin.example.BookMyShow.model.constant.MovieType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    @ManyToMany
    private List<Actors> actors;
    private double duration;
    @Enumerated(EnumType.STRING)
    private MovieType movieType;
}
