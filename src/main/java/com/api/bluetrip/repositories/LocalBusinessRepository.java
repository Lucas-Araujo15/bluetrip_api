package com.api.bluetrip.repositories;

import com.api.bluetrip.models.LocalBusiness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalBusinessRepository extends JpaRepository<LocalBusiness, Long> {
}
