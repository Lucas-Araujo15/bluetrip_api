package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.address.AddressRegisterDTO;
import com.api.bluetrip.controllers.dtos.address.AddressUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "T_BT_ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address", nullable = false)
    private Long id;

    @Column(name = "ds_street", nullable = false)
    private String street;

    @Column(name = "ds_city", nullable = false)
    private String city;

    @Column(name = "nr_zip_code", nullable = false)
    private String zipCode;

    @Column(name = "ds_state", nullable = false)
    private String state;

    @Column(name = "ds_neighborhood", nullable = false)
    private String neighborhood;

    @Column(name = "nr_building", nullable = true)
    private String numberBuilding;

    @Column(name = "ds_complement", nullable = true)
    private String complement;

    public Address(AddressRegisterDTO addressRegisterDTO) {
        this.street = addressRegisterDTO.street();
        this.city = addressRegisterDTO.city();
        this.zipCode = addressRegisterDTO.zipCode();
        this.state = addressRegisterDTO.state();
        this.neighborhood = addressRegisterDTO.neighborhood();
        this.numberBuilding = addressRegisterDTO.numberBuilding();
        this.complement = addressRegisterDTO.complement();
    }

    public void updateInformation(AddressUpdateDTO addressUpdateDTO) {
        if (addressUpdateDTO.street() != null) {
            this.street = addressUpdateDTO.street();
        }

        if (addressUpdateDTO.city() != null) {
            this.city = addressUpdateDTO.city();
        }

        if (addressUpdateDTO.zipCode() != null) {
            this.zipCode = addressUpdateDTO.zipCode();
        }

        if (addressUpdateDTO.state() != null) {
            this.state = addressUpdateDTO.state();
        }

        if (addressUpdateDTO.neighborhood() != null) {
            this.neighborhood = addressUpdateDTO.neighborhood();
        }

        if (addressUpdateDTO.numberBuilding() != null) {
            this.numberBuilding = addressUpdateDTO.numberBuilding();
        }

        if (addressUpdateDTO.complement() != null) {
            this.complement = addressUpdateDTO.complement();
        }
    }
}
