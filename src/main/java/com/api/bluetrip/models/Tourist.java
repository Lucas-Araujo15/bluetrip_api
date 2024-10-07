package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.tourist.TouristRegisterDTO;
import com.api.bluetrip.controllers.dtos.tourist.TouristUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "T_BT_TOURIST")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tourist")
public class Tourist {
    @Id
    @GeneratedValue
    @Column(name = "id_tourist", nullable = false)
    private Long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "ds_nationality", nullable = false)
    private String nationality;

    @Column(name = "nr_phone", nullable = false)
    private String phone;

    @Column(name = "dt_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "ds_gender", nullable = false)
    private String gender;

    @Column(name = "ds_language", nullable = false)
    private String language;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_user_id_user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_tourist_id_tourist")
    private List<ServiceUsage> serviceUsageList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_tourist_id_tourist")
    private List<Booking> bookingList;

    public Tourist(TouristRegisterDTO touristRegisterDTO) {
        this.gender = touristRegisterDTO.gender();
        this.dateOfBirth = touristRegisterDTO.dateOfBirth();
        this.language = touristRegisterDTO.language();
        this.name = touristRegisterDTO.name();
        this.nationality = touristRegisterDTO.nationality();
        this.phone = touristRegisterDTO.phone();
        this.user = new User(touristRegisterDTO.user());
    }

    public void updateInformation(TouristUpdateDTO touristUpdateDTO) {
        if (touristUpdateDTO.dateOfBirth() != null) {
            this.dateOfBirth = touristUpdateDTO.dateOfBirth();
        }

        if (touristUpdateDTO.gender() != null) {
            this.gender = touristUpdateDTO.gender();
        }

        if (touristUpdateDTO.name() != null) {
            this.name = touristUpdateDTO.name();
        }

        if (touristUpdateDTO.phone() != null) {
            this.phone = touristUpdateDTO.phone();
        }

        if (touristUpdateDTO.language() != null) {
            this.language = touristUpdateDTO.language();
        }

        if (touristUpdateDTO.nationality() != null) {
            this.nationality = touristUpdateDTO.nationality();
        }
    }
}
