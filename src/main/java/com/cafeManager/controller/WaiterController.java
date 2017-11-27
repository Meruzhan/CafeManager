package com.cafeManager.controller;

import com.cafeManager.api.service.WaiterService;
import com.cafeManager.model.Order;
import com.cafeManager.model.Product;
import com.cafeManager.model.Table;
import com.cafeManager.model.User;
import com.cafeManager.model.OrderStatus;
import com.cafeManager.model.StatusProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Gasparyan on 26.11.2017.
 */

@RestController
@RequestMapping("/waiter")
public class WaiterController {

    private WaiterService waiterService;


    @RequestMapping(value = "{userId}/{tableId}",method = RequestMethod.PUT)
    public void joinTable(@PathVariable long tableid,@PathVariable long waiterId) {

    }


    @RequestMapping(value = "table/{tableId}/add/{orderId}",method = RequestMethod.POST)
    public void joinOrderInTable(@PathVariable long tableId, @PathVariable Long orderId) {
         waiterService.joinOrderInTable(tableId,orderId);
    }

    @RequestMapping(value = "orders/{orderId}/product/{productId}/{count}",method = RequestMethod.POST)
    public void addProductInOrder(@PathVariable long orderId,@PathVariable long productId, @PathVariable int count) {
        waiterService.addProductInOrder(orderId,productId,count);
    }

    @RequestMapping(value = "orders/{orderId}/product/{productId}/status/{statusId}", method = RequestMethod.PUT)
    public void editProductStatusInOrdered(@PathVariable long orderId, @PathVariable long productId, @PathVariable long statusId) {
        waiterService.editProductStatusInOrdered(orderId,productId,statusId);
    }

    @RequestMapping(value = "orders/{orderId}/product/{productId}/{count}",method = RequestMethod.PUT)
    public void editProductCountInOrdered(@PathVariable long orderId,@PathVariable long productId, @PathVariable int count) {
        waiterService.editProductCountInOrdered(orderId,productId,count);
    }


    @RequestMapping(value = "orders/{orderId}/status/{statusId}",method = RequestMethod.PUT)
    public void editOrderStatus(@PathVariable long orderId,@PathVariable long statusId) {
        waiterService.editOrderStatus(orderId,statusId);
    }


    public WaiterService getWaiterService() {
        return waiterService;
    }

    @Autowired
    public void setWaiterService(WaiterService waiterService) {
        this.waiterService = waiterService;
    }

}
