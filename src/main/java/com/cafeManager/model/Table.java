package com.cafeManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Gasparyan on 26.11.2017.
 */
@Entity(name = "Cafetable")
@javax.persistence.Table(name = "Cafetable")
public class Table implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "waiterid")
    private User waiter;


    @OneToMany(mappedBy = "cafeTable",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;



    public Table(){}

    public Table(String name) {
        this.name = name;

    }

    public Table(String name, Order orders, User waiter) {
       this(name,orders);
        this.waiter = waiter;
    }

    public Table(String name, Order orders ) {
        this(name);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public boolean isActiveOrder(){
        return  orders.stream().filter(order -> "Activ".equals(order.getStatus().getName())).count() > 0 ;
    }


}
