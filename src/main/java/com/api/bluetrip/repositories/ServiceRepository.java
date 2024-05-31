package com.api.bluetrip.repositories;

import com.api.bluetrip.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
