package dev.Nithin.example.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    @OneToMany
    private List<Ticket> tickets;
}
