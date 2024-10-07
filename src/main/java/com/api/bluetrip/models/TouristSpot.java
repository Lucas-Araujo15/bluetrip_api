package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotRegisterDTO;
import com.api.bluetrip.controllers.dtos.touristspot.TouristSpotUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "T_BT_TOURIST_SPOT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tourist_spot")
public class TouristSpot {
    @Id
    @GeneratedValue
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_address_id_address")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_tourist_spot_id_tourist_spot")
    private List<Event> eventList;

    public TouristSpot(TouristSpotRegisterDTO touristSpotRegisterDTO) {
        this.name = touristSpotRegisterDTO.name();
        this.description = touristSpotRegisterDTO.description();
        this.averageRate = touristSpotRegisterDTO.averageRate();
        this.price = touristSpotRegisterDTO.price();
        this.phone = touristSpotRegisterDTO.phone();
        this.urlImage = touristSpotRegisterDTO.urlImage();
        this.category = touristSpotRegisterDTO.category();
        this.address = new Address(touristSpotRegisterDTO.address());
    }

    public void updateInformation(TouristSpotUpdateDTO touristSpotUpdateDTO) {
        if (touristSpotUpdateDTO.name() != null) {
            this.name = touristSpotUpdateDTO.name();
        }

        if (touristSpotUpdateDTO.description() != null) {
            this.description = touristSpotUpdateDTO.description();
        }

        if (touristSpotUpdateDTO.averageRate() != 0.0f) {
            this.averageRate = touristSpotUpdateDTO.averageRate();
        }

        if (touristSpotUpdateDTO.price() != 0.0f) {
            this.price = touristSpotUpdateDTO.price();
        }

        if (touristSpotUpdateDTO.phone() != null) {
            this.phone = touristSpotUpdateDTO.phone();
        }

        if (touristSpotUpdateDTO.urlImage() != null) {
            this.urlImage = touristSpotUpdateDTO.urlImage();
        }

        if (touristSpotUpdateDTO.category() != null) {
            this.category = touristSpotUpdateDTO.category();
        }
    }
}
