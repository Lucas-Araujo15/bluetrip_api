package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.serviceusage.ServiceUsageRegisterDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "T_BT_SERVICE_USAGE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "service_usage")
public class ServiceUsage {
    @Id
    @GeneratedValue
    @Column(name = "id_service_usage", nullable = false)
    private Long id;

    @Column(name = "dt_usage", nullable = false)
    private LocalDateTime dateUsage;

    @Column(name = "nr_rate", nullable = true)
    private float rate;

    @Column(name = "tx_comment", nullable = true)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "t_bt_service_id_service")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "t_bt_tourist_id_tourist")
    private Tourist tourist;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_payment_id_payment")
    private Payment payment;

    public ServiceUsage(ServiceUsageRegisterDTO serviceUsageRegisterDTO) {
        this.dateUsage = serviceUsageRegisterDTO.dateUsage();
        this.payment = new Payment(serviceUsageRegisterDTO.paymentRegisterDTO());
    }
}
