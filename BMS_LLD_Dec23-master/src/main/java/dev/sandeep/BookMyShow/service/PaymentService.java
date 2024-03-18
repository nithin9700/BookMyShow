package dev.sandeep.BookMyShow.service;
import dev.sandeep.BookMyShow.model.Payment;
import dev.sandeep.BookMyShow.model.Ticket;
import dev.sandeep.BookMyShow.model.constant.PaymentMode;
import dev.sandeep.BookMyShow.model.constant.PaymentStatus;
import dev.sandeep.BookMyShow.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;


    public Payment getPaymentById(int paymentId){
        return paymentRepository.findById(paymentId).get();
    }

    public Payment savePayment(double paymentAmount, String referenceId, PaymentMode paymentMode,
                               Ticket ticket,  PaymentStatus paymentStatus){
        Payment payment = new Payment();
        payment.setReferenceId(referenceId);
        payment.setPaymentTime(LocalDateTime.now());
        payment.setAmount(paymentAmount);
        payment.setPaymentMode(paymentMode);
        payment.setTicket(ticket);
        payment.setPaymentStatus(paymentStatus);

        return paymentRepository.save(payment);
    }

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public boolean deletePayment(int paymentId){
        paymentRepository.deleteById(paymentId);
        return true;
    }
}
