package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.administrator.AdministratorRegisterDTO;
import com.api.bluetrip.controllers.dtos.administrator.AdministratorUpdateDTO;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public Administrator(AdministratorRegisterDTO administratorRegisterDTO) {
        this.name = administratorRegisterDTO.name();
        this.phone = administratorRegisterDTO.phone();
        this.role = administratorRegisterDTO.role();
        this.user = new User(administratorRegisterDTO.user());
    }

    public void updateInformation(AdministratorUpdateDTO administratorUpdateDTO) {
        if (administratorUpdateDTO.name() != null) {
            this.name = administratorUpdateDTO.name();
        }

        if (administratorUpdateDTO.phone() != null) {
            this.phone = administratorUpdateDTO.phone();
        }

        if (administratorUpdateDTO.role() != null) {
            this.role = administratorUpdateDTO.role();
        }
    }
}
