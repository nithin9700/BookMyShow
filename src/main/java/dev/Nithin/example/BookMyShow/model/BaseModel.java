package dev.Nithin.example.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private int id;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")

    private LocalDateTime updatedAt;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "UPDATE_BY")
    private String updatedBy;
}
