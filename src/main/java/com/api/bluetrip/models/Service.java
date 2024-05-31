package com.api.bluetrip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "T_BT_SERVICE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_service", nullable = false)
    private Long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "tx_description", nullable = false)
    private String description;

    @Column(name = "vl_price", nullable = false)
    private float price;

    @Column(name = "ds_category", nullable = false)
    private String category;
}
