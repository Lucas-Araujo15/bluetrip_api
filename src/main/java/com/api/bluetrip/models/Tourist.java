package com.api.bluetrip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "T_BT_TOURIST")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tourist")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
