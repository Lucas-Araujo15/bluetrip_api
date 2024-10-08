package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.user.UserRegisterDTO;
import com.api.bluetrip.controllers.dtos.user.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "T_BT_USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqUser")
    @SequenceGenerator(name = "seqUser", sequenceName = "SEQ_T_BT_USER", allocationSize = 1)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @Column(name = "ds_email", nullable = false)
    private String email;

    @Column(name = "ds_password", nullable = false)
    private String password;

    @Column(name = "dt_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "ds_user_type", nullable = false)
    private String userType;

    public User(UserRegisterDTO userRegisterDTO) {
        this.email = userRegisterDTO.email();
        this.userType = userRegisterDTO.userType();
        this.password = userRegisterDTO.password();
        this.createdAt = LocalDateTime.now();
    }

    public void updateInformation(UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO.email() != null) {
            this.email = userUpdateDTO.email();
        }

        if (userUpdateDTO.password() != null) {
            this.password = userUpdateDTO.password();
        }
    }
}
