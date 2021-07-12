package com.primesource.primesource.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="t_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="title",nullable = false)
    private String title;

    @Column(name="date",nullable = false)
    private Timestamp date;

    @Column(name="priority",nullable = false)
    private boolean priority;

    @Column(name="done")
    private boolean done;

    @Column(name="description")
    private String description;


}
