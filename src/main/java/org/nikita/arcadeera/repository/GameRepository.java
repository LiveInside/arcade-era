package org.nikita.arcadeera.repository;

import org.nikita.arcadeera.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface GameRepository extends JpaRepository<Game, Integer> {
}
