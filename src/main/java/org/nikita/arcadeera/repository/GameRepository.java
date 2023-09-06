package org.nikita.arcadeera.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.nikita.arcadeera.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
