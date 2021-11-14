package com.exercise.asaidemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "fact")
    private String fact;

    @Column(name = "consequence")
    private String consequence;

    public Offer() {
    }

    public Offer(long id, String name, String fact, String consequence) {
                this.id = id;
                this.name = name;
                this.fact = fact;
                this.consequence = consequence;
        }
}
