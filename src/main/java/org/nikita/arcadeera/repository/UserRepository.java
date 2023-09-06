package org.nikita.arcadeera.repository;

import org.nikita.arcadeera.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
