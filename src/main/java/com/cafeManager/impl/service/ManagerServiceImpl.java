package com.cafeManager.impl.service;

import com.cafeManager.api.service.ManagerService;
import com.cafeManager.model.Product;
import com.cafeManager.model.Table;
import com.cafeManager.model.User;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Gasparyan on 26.11.2017.
 */
@Service
public class ManagerServiceImpl implements ManagerService{

    private SessionFactory sessionFactory;


    @Autowired
    public ManagerServiceImpl(EntityManagerFactory factory) {
        this.sessionFactory =  factory.unwrap(SessionFactory.class);
    }


    @Override
    public User createUser(User user) {
        Session session = sessionFactory.openSession();
        user.setId((Long) session.save( user ));
        return user;
    }

    @Override
    public Table createTable(Table table) {
        Session session = sessionFactory.openSession();
        table.setId((Long) session.save(table));
        return table ;
    }


    @Override
    public Product createProduct(Product product) {
        Session session = sessionFactory.openSession();
        product.setId((Long) session.save(product));
        return product;
    }

    @Override
    public void joinTableToWaiter(long waiterId, long tableId) {
        Session session = sessionFactory.openSession();
         Table joinTable =  session.byId(Table.class).load(tableId);
         if(joinTable.getWaiter() ==null){
             User waiter = session.byId(User.class).load(waiterId);
             if(waiter!= null && "WAITER".equals(waiter.getRole().getName())){
                 joinTable.setWaiter(waiter);
                 SQLQuery query = session.createSQLQuery("UPDATE CafeTable SET waiterid=:waiterid WHERE CafeTable.Id =:cafeTableId");
                query.setParameter("cafeTableId",tableId);
                query.setParameter("waiterid",waiterId);
                query.executeUpdate();
             }

         }
    }

}
