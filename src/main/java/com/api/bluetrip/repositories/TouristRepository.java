package com.api.bluetrip.repositories;

import com.api.bluetrip.models.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
