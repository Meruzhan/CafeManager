package com.cafeManager.model;

import javax.persistence.*;
import javax.persistence.Table;

/**
 * Created by Gasparyan on 27.11.2017.
 */

@Entity
@Table(name = "productorder")
public class ProductOrder {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "orderid")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tableid")
    private com.cafeManager.model.Table table;

    @Column(name = "productcount")
    private int productCount;


    @ManyToOne
    @JoinColumn(name = "statusid")
    private StatusProductOrder status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public com.cafeManager.model.Table getTable() {
        return table;
    }

    public void setTable(com.cafeManager.model.Table table) {
        this.table = table;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public StatusProductOrder getStatus() {
        return status;
    }

    public void setStatus(StatusProductOrder status) {
        this.status = status;
    }
}
