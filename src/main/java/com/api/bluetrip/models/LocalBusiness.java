package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessRegisterDTO;
import com.api.bluetrip.controllers.dtos.localbusiness.LocalBusinessUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Table(name = "T_BT_LOCAL_BUSINESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "local_business")
public class LocalBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLocalBusiness")
    @SequenceGenerator(name = "seqLocalBusiness", sequenceName = "SEQ_T_BT_LOCAL_BUSINESS", allocationSize = 1)
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_user_id_user")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_address_id_address")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_local_business_id_local_business")
    private List<Service> serviceList;

    public LocalBusiness(LocalBusinessRegisterDTO localBusinessRegisterDTO) {
        this.tradeName = localBusinessRegisterDTO.tradeName();
        this.businessCategory = localBusinessRegisterDTO.businessCategory();
        this.closeHour = localBusinessRegisterDTO.closeHour();
        this.description = localBusinessRegisterDTO.description();
        this.openHour = localBusinessRegisterDTO.openHour();
        this.phone = localBusinessRegisterDTO.phone();
        this.urlImage = localBusinessRegisterDTO.urlImage();
        this.urlWebsite = localBusinessRegisterDTO.urlWebsite();
        this.user = new User(localBusinessRegisterDTO.user());
        this.address = new Address(localBusinessRegisterDTO.address());
    }

    public void updateInformation(LocalBusinessUpdateDTO localBusinessUpdateDTO) {
        if (localBusinessUpdateDTO.tradeName() != null) {
            this.tradeName = localBusinessUpdateDTO.tradeName();
        }

        if (localBusinessUpdateDTO.description() != null) {
            this.description = localBusinessUpdateDTO.description();
        }

        if (localBusinessUpdateDTO.urlWebsite() != null) {
            this.urlWebsite = localBusinessUpdateDTO.urlWebsite();
        }

        if (localBusinessUpdateDTO.urlImage() != null) {
            this.urlImage = localBusinessUpdateDTO.urlImage();
        }

        if (localBusinessUpdateDTO.openHour() != null) {
            this.openHour = localBusinessUpdateDTO.openHour();
        }

        if (localBusinessUpdateDTO.closeHour() != null) {
            this.closeHour = localBusinessUpdateDTO.closeHour();
        }

        if (localBusinessUpdateDTO.phone() != null) {
            this.phone = localBusinessUpdateDTO.phone();
        }

        if (localBusinessUpdateDTO.businessCategory() != null) {
            this.businessCategory = localBusinessUpdateDTO.businessCategory();
        }
    }
}
