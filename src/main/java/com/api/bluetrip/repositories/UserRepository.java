package com.api.bluetrip.repositories;

import com.api.bluetrip.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
