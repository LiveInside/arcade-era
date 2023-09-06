package org.nikita.arcadeera.repository;

import org.nikita.arcadeera.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
