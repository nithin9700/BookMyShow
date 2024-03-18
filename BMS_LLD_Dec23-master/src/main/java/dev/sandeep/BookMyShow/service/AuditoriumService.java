package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.model.Auditorium;
import dev.sandeep.BookMyShow.model.Seat;
import dev.sandeep.BookMyShow.model.constant.AuditoriumFeature;
import dev.sandeep.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public Auditorium getAuditoriumByName(String auditoriumName){
        Auditorium auditorium = auditoriumRepository.findauditoriumByName(auditoriumName);
        return auditorium;
    }

    public Auditorium getAuditoriumById(int auditoriumId){
        return auditoriumRepository.findById(auditoriumId).get();
    }

    public Auditorium saveauditorium(String auditoriumName, List<AuditoriumFeature> auditoriumFeatureList,
                                     int capacity, List<Seat> seatList){
        Auditorium auditorium = new Auditorium();
        auditorium.setCapacity(capacity);
        auditorium.setSeats(seatList);
        auditorium.setName(auditoriumName);
        auditorium.setAuditoriumFeatures(auditoriumFeatureList);
        return auditoriumRepository.save(auditorium);
    }

    public Auditorium saveauditorium(Auditorium auditorium){
        return auditoriumRepository.save(auditorium);
    }

    public boolean deleteAuditorium(int auditoriumId){
        auditoriumRepository.deleteById(auditoriumId);
        return true;
    }
}
