package com.api.bluetrip.controllers;

import com.api.bluetrip.controllers.dtos.payment.DetailedPaymentDTO;
import com.api.bluetrip.controllers.dtos.payment.PaymentUpdateDTO;
import com.api.bluetrip.services.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedPaymentDTO> update(@RequestBody @Valid PaymentUpdateDTO paymentUpdateDTO, @PathVariable("id") Long id) {
        DetailedPaymentDTO detailedPaymentDTO = paymentService.update(id, paymentUpdateDTO);
        return ResponseEntity.ok(detailedPaymentDTO);
    }
}
