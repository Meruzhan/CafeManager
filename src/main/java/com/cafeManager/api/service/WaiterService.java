package com.cafeManager.api.service;

import com.cafeManager.model.Order;
import com.cafeManager.model.Product;
import com.cafeManager.model.Table;
import com.cafeManager.model.User;
import com.cafeManager.model.OrderStatus;
import com.cafeManager.model.StatusProductOrder;


import java.util.List;

/**
 * Created by Gasparyan on 26.11.2017.
 */
public interface WaiterService {

    List<User>getAllWaiter();

    void joinTable(long waiterId,long table);

    void joinOrderInTable(long tableId,long orderId);

    void addProductInOrder(long order, long product, int count);

    void editProductStatusInOrdered(long orderId,long productId,long statusId);

    void editProductCountInOrdered(long orderId,long productId,int count);

    void editOrderStatus(long orderId, long statusId);

    List<Table> loadAllTable();

    public void changeProduct(Product product, StatusProductOrder status);

    public void changeProduct(Product product, int count);
}
