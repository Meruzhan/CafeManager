package com.cafeManager.api.service;

import com.cafeManager.model.Order;
import com.cafeManager.model.Product;
import com.cafeManager.model.Table;
import com.cafeManager.model.User;
import com.cafeManager.model.Role;

import java.math.BigDecimal;

/**
 * Created by Gasparyan on 26.11.2017.
 */
public interface ManagerService {


    User createUser(User user);

    Table createTable(Table table);

    Product createProduct(Product product);

    void joinTableToWaiter(long waiterId, long tableId);
}
