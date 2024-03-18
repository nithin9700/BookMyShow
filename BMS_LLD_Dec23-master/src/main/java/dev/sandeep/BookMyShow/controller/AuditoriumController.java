package dev.sandeep.BookMyShow.controller;

import dev.sandeep.BookMyShow.dto.AuditoriumRequestDTO;
import dev.sandeep.BookMyShow.model.Auditorium;
import dev.sandeep.BookMyShow.model.constant.AuditoriumFeature;
import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
public class AuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;

    public ResponseEntity createAuditorium(@RequestBody AuditoriumRequestDTO auditoriumRequestDTO){
        String auditoriumName = auditoriumRequestDTO.getName();
        String theatreName = auditoriumRequestDTO.getTheatre();
        int capacity = auditoriumRequestDTO.getCapacity();
        List<AuditoriumFeature> list = auditoriumRequestDTO.getAuditoriumFeatures();
        return null;
    }
}
