package com.cafeManager.model;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by Gasparyan on 26.11.2017.
 */
@Entity
@Table(name = "StatusProductOrder")
public class StatusProductOrder {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
