package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.repository.CityRepository;
import dev.sandeep.BookMyShow.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
}
