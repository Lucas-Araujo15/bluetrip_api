package com.api.bluetrip.models;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_service_usage", nullable = false)
    private Long id;

    @Column(name = "dt_usage", nullable = false)
    private LocalDateTime dateUsage;

    @Column(name = "nr_rate", nullable = true)
    private float rate;

    @Column(name = "tx_comment", nullable = true)
    private String comment;
}
