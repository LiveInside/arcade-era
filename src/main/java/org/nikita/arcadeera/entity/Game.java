package org.nikita.arcadeera.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "game")
@Data
@Accessors(chain = true)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "platform")
    private String platform;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "age_rating")
    private String ageRating;

    @Column(name = "user_evaluation")
    private BigDecimal userEvaluation;

    @Column(name = "hide")
    private boolean hide;

    @OneToMany(mappedBy = "game_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    @ManyToOne
    private Publisher publisher;
}
