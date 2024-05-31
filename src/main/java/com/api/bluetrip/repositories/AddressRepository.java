package com.api.bluetrip.repositories;

import com.api.bluetrip.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
