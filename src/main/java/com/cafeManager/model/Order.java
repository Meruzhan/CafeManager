package com.cafeManager.model;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Gasparyan on 26.11.2017.
 */
@Entity(name = "CafeOrder")
@Table(name = "Cafeorder")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private long number;

    @ManyToOne
    @JoinColumn(name = "statusid")
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "tableid")
    private com.cafeManager.model.Table cafeTable;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getNumber() {
        return this.number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public com.cafeManager.model.Table getCafeTable() {
        return cafeTable;
    }

    public void setCafeTable(com.cafeManager.model.Table cafeTable) {
        this.cafeTable = cafeTable;
    }



    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
