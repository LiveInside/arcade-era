package org.nikita.arcadeera.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "plarform")
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

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "game")
    private List<User> users = new ArrayList<>();
}
