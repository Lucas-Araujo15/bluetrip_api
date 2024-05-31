package com.api.bluetrip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Table(name = "T_BT_LOCAL_BUSINESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "local_business")
public class LocalBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_local_business", nullable = false)
    private Long id;

    @Column(name = "ds_trade_name", nullable = false)
    private String tradeName;

    @Column(name = "tx_description", nullable = false)
    private String description;

    @Column(name = "nr_average_rating", nullable = true)
    private float averageRating;

    @Column(name = "url_website", nullable = false)
    private String urlWebsite;

    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @Column(name = "ds_open_hour", nullable = false)
    private LocalTime openHour;

    @Column(name = "ds_close_hour", nullable = false)
    private LocalTime closeHour;

    @Column(name = "nr_phone", nullable = false)
    private String phone;

    @Column(name = "ds_business_category", nullable = false)
    private String businessCategory;
}
