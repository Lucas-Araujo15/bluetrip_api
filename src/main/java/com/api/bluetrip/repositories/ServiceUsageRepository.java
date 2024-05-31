package com.api.bluetrip.repositories;

import com.api.bluetrip.models.ServiceUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUsageRepository extends JpaRepository<ServiceUsage, Long> {
}
