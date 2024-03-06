package dev.Nithin.example.BookMyShow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Actors extends BaseModel{
    @Column(name = "NAME")
    private String name;
}
