package org.nikita.arcadeera.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "t_game")
@Getter
@Setter
@Accessors(chain = true)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", updatable = false)
    private String name;

    @Column(name = "platform", updatable = false)
    private String platform;

    @Column(name = "genre", updatable = false)
    private String genre;

    @Column(name = "price", updatable = true)
    private BigDecimal price;

    @Column(name = "age_rating", updatable = false)
    private String ageRating;

    @Column(name = "user_evaluation", updatable = true)
    private BigDecimal userEvaluation;

    @Column(name = "hide", updatable = true)
    private boolean hide;

    @OneToMany(mappedBy = "game")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
