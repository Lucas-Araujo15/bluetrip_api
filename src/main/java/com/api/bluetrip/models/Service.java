package com.api.bluetrip.models;

import com.api.bluetrip.controllers.dtos.service.ServiceRegisterDTO;
import com.api.bluetrip.controllers.dtos.service.ServiceUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "T_BT_SERVICE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue
    @Column(name = "id_service", nullable = false)
    private Long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "tx_description", nullable = false)
    private String description;

    @Column(name = "vl_price", nullable = false)
    private float price;

    @Column(name = "ds_category", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "t_bt_local_business_id_local_business")
    private LocalBusiness localBusiness;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "t_bt_service_id_service")
    private List<ServiceUsage> serviceUsageList;

    public Service(ServiceRegisterDTO serviceRegisterDTO) {
        this.name = serviceRegisterDTO.name();
        this.description = serviceRegisterDTO.description();
        this.price = serviceRegisterDTO.price();
        this.category = serviceRegisterDTO.category();
    }

    public void updateInformation(ServiceUpdateDTO serviceUpdateDTO) {
        if (serviceUpdateDTO.name() != null) {
            this.name = serviceUpdateDTO.name();
        }

        if (serviceUpdateDTO.description() != null) {
            this.description = serviceUpdateDTO.description();
        }

        if (serviceUpdateDTO.price() != 0.0f) {
            this.price = serviceUpdateDTO.price();
        }

        if (serviceUpdateDTO.category() != null) {
            this.category = serviceUpdateDTO.category();
        }
    }
}
