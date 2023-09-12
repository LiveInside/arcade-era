package org.nikita.arcadeera.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Entity
@Table(name = "t_publisher")
@Getter @Setter
@Accessors(chain = true)
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", updatable = false)
    private String name;

    @Column(name = "country", updatable = true)
    private String country;

    @Column(name = "hide", updatable = true)
    private boolean hide;

    @OneToMany(mappedBy = "publisher")
    private List<Game> games;
}