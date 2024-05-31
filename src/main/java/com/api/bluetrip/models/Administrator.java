package com.api.bluetrip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "T_BT_ADMINISTRATOR")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "nr_phone", nullable = false)
    private String phone;

    @Column(name = "ds_role", nullable = true)
    private String role;
}
