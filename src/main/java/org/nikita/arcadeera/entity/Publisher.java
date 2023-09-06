package org.nikita.arcadeera.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "county")
    @Getter @Setter
    private String country;

    @Column(name = "hide")
    @Getter @Setter
    private boolean hide;

    @OneToMany(mappedBy = "publisher")
    @Getter
    private List<Game> games = new ArrayList<>();
}
