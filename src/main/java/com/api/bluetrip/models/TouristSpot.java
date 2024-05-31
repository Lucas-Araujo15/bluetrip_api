package com.api.bluetrip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "T_BT_TOURIST_SPOT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tourist_spot")
public class TouristSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tourist_spot", nullable = false)
    private Long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "tx_description", nullable = false)
    private String description;

    @Column(name = "nr_average_rate", nullable = false)
    private float averageRate;

    @Column(name = "vl_price", nullable = false)
    private float price;

    @Column(name = "nr_phone", nullable = true)
    private String phone;

    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @Column(name = "ds_category", nullable = false)
    private String category;
}
