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
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    private Integer id;

    @Column(name = "name")
    @Getter @Setter
    private String name;

    @Column(name = "plarform")
    @Getter @Setter
    private String platform;

    @Column(name = "genre")
    @Getter @Setter
    private String genre;

    @Column(name = "price")
    @Getter @Setter
    private BigDecimal price;

    @Column(name = "age_rating")
    @Getter @Setter
    private String ageRating;

    @Column(name = "user_evaluation")
    @Getter @Setter
    private BigDecimal userEvaluation;

    @Column(name = "hide")
    @Getter @Setter
    private boolean hide;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @Getter @Setter
    private Publisher publisher;

    @OneToMany(mappedBy = "game")
    @Getter
    private List<User> users = new ArrayList<>();

}
