package com.example.tallink.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conference")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "time")
    private Instant time;

    public Conference(String name, Instant time) {
        this.name = name;
        this.time = time;
    }
}
