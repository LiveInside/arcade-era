package org.nikita.arcadeera.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Table(name = "t_user")
@Getter
@Setter
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "region", updatable = true)
    private String region;

    @Column(name = "age", updatable = false)
    private Short age;

    @Column(name = "balance", updatable = true)
    private BigDecimal balance;

    @Column(name = "name", updatable = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
