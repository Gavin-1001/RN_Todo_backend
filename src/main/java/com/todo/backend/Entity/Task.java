package com.todo.backend.Entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String title;

    @Column()
    private String text;
    @Column()
    private Boolean reminder;
    @Column()
    private Date date_completed;
    @Column()
    private Date date_created;

    public Task(Long id, String title, String text, Boolean reminder, Date date_completed, Date date_created) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.reminder = reminder;
        this.date_completed = date_completed;
        this.date_created = date_created;
    }

    public Task(){}
}
