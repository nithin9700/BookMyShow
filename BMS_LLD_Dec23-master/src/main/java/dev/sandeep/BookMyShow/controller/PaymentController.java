package dev.sandeep.BookMyShow.controller;

import dev.sandeep.BookMyShow.service.ActorService;
import dev.sandeep.BookMyShow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

}
