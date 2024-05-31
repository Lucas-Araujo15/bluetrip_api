package com.api.bluetrip.models;

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
}
