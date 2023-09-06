package org.nikita.arcadeera.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    private Integer id;

    @Column(name = "region")
    @Getter @Setter
    private String region;

    @Column(name = "age")
    @Getter @Setter
    private Short age;

    @Column(name = "balance")
    @Getter @Setter
    private BigDecimal balance;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @Getter @Setter
    private Game game;
}
