package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.payment.PaymentRegisterDTO;
import com.api.bluetrip.controllers.dtos.payment.PaymentUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "T_BT_PAYMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqPayment")
    @SequenceGenerator(name = "seqPayment", sequenceName = "SEQ_T_BT_PAYMENT", allocationSize = 1)
    @Column(name = "id_payment", nullable = false)
    private Long id;

    @Column(name = "ds_payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "vl_total_price", nullable = false)
    private float totalPrice;

    @Column(name = "st_payment", nullable = false)
    private String statusPayment;

    @Column(name = "dt_payment", nullable = true)
    private LocalDateTime datePayment;

    public Payment(PaymentRegisterDTO paymentRegisterDTO) {
        this.paymentMethod = paymentRegisterDTO.paymentMethod();
        this.totalPrice = paymentRegisterDTO.totalPrice();
        this.statusPayment = "PENDING";
    }

    public void updateInformation(PaymentUpdateDTO paymentUpdateDTO) {
        if (paymentUpdateDTO.datePayment() != null) {
            this.datePayment = paymentUpdateDTO.datePayment();
        }

        if (paymentUpdateDTO.statusPayment() != null) {
            this.statusPayment = paymentUpdateDTO.statusPayment();
        }
    }
}
