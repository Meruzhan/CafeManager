package com.cafeManager.controller;

import com.cafeManager.api.service.ManagerService;
import com.cafeManager.model.Order;
import com.cafeManager.model.Product;
import com.cafeManager.model.Table;
import com.cafeManager.model.User;
import com.cafeManager.model.Role;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by Gasparyan on 26.11.2017.
 */
@Controller
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;

    @RequestMapping(value = "user/add" ,method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return managerService.createUser(user);
    }


    @RequestMapping(value = "table/add",method = RequestMethod.POST)
    public Table createTable(@RequestBody Table table) {
        return managerService.createTable(table);
    }


    @RequestMapping(value = "product/add", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return managerService.createProduct(product);
    }

    @RequestMapping(value = "joinTable/{waiterId}/{tableId}",method = RequestMethod.PUT)
    public void joinTableToWaiter(@PathVariable Long waiterId, @PathVariable Long tableId) {
       managerService.joinTableToWaiter(waiterId,tableId);
    }

    public ManagerService getManagerService() {
        return managerService;
    }

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }
}
