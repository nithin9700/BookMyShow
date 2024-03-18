package dev.sandeep.BookMyShow.dto;

import dev.sandeep.BookMyShow.model.constant.AuditoriumFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditoriumRequestDTO {
    private String name;
    private String theatre;
    private int capacity;
    private List<AuditoriumFeature> auditoriumFeatures;
}
