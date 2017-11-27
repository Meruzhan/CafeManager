package com.cafeManager.impl.service;

import com.cafeManager.api.service.WaiterService;
import com.cafeManager.model.Product;
import com.cafeManager.model.StatusProductOrder;
import com.cafeManager.model.Table;
import com.cafeManager.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Gasparyan on 26.11.2017.
 */

@Service
public class WaiterServiceImpl implements WaiterService {




    private SessionFactory sessionFactory;
    private EntityManagerFactory factory;

    @Autowired
    public WaiterServiceImpl(EntityManagerFactory factory) {
        this.sessionFactory =  factory.unwrap(SessionFactory.class);
	    this.factory = factory;
    }

    @Override
    public List<User> getAllWaiter() {
        Session session = sessionFactory.openSession();
       SQLQuery query = session.createSQLQuery("SELECT  * from member WHERE member.roleid = :role");
      List<User> waiter =  query.setParameter("role",2).list();
      session.close();
        return waiter;
    }

    @Override
    public void joinTable(long waiterId,long tableId) {
        Session session = sessionFactory.openSession();
            SQLQuery query = session.createSQLQuery("UPDATE CafeTable SET waiterId=:waiterId WHERE CafeTable.Id =:tableId");
            query.setParameter("tableId", tableId);
            query.setParameter("waiterId", waiterId);
            query.executeUpdate();
            session.close();

    }

    @Override
    public void joinOrderInTable(long tableId, long orderId) {
        Session session = sessionFactory.openSession();
        Table table =  session.byId(Table.class).load(tableId);
        if(table!= null && table.isActiveOrder()) {
            SQLQuery query = session.createSQLQuery("UPDATE [ORDER] SET tableId=:tableId WHERE [ORDER].Id =:orderId");
            query.setParameter("tableId", tableId);
            query.setParameter("orderId", orderId);
            query.executeUpdate();
            session.close();
        }else {
            throw new IllegalArgumentException("table not have two open order");
        }

    }

    @Override
    public void addProductInOrder(long orderId, long productId, int count) {
        Session session = sessionFactory.openSession();
        SQLQuery query =  session.createSQLQuery("UPDATE PRODUCTORDER SET statusId=:status WHERE PRODUCTORDER.ProductId =:productid AND orderid = :orderid");
        query.setParameter("productid",productId);
        query.setParameter("orderid",orderId);
        query.setParameter("status",1);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void editProductStatusInOrdered(long orderId, long productId, long statusId) {
        Session session = sessionFactory.openSession();
        SQLQuery query =  session.createSQLQuery("UPDATE PRODUCTORDER SET statusId=:status WHERE PRODUCTORDER.ProductId =:productid AND orderid = :orderid");
        query.setParameter("productid",productId);
        query.setParameter("orderid",orderId);
        query.setParameter("status",statusId);
        query.executeUpdate();
        session.close();
    }

    @Override
    public void editProductCountInOrdered(long orderId, long productId, int count) {
        Session session = sessionFactory.openSession();
        SQLQuery query =  session.createSQLQuery("UPDATE PRODUCTORDER SET Productcount=:productCount WHERE PRODUCTORDER.ProductId =:productid AND orderid = :orderid");
        query.setParameter("productid",productId);
        query.setParameter("orderid",orderId);
        query.setParameter("productCount",count);
        query.executeUpdate();
        session.close();

    }

    @Override
    public void editOrderStatus(long orderId, long statusId) {
        Session session = sessionFactory.openSession();
        SQLQuery query =  session.createSQLQuery("UPDATE [ORDER] SET statusid=:statusId WHERE [order].Id =:orderid");
        query.setParameter("orderid",orderId);
        query.setParameter("statusId",statusId);
        query.executeUpdate();
        session.close();
    }

    @Override
    public List<Table> loadAllTable() {
        return null;
    }

    public List<Product> getProducts() {
        return null;
    }

    public void setProduct(Product product) {

    }

    @Override
    public void changeProduct(Product product, StatusProductOrder status) {

    }


    @Override
    public void changeProduct(Product product, int count) {

    }
}
