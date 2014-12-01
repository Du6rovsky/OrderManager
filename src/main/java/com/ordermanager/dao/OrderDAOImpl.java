package com.ordermanager.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ordermanager.domain.Order;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void addOrder(Order order) { 
        sessionFactory.getCurrentSession().save(order);
    }    
    public Order downloadOrder(Integer id) {
        Session session = sessionFactory.getCurrentSession();
		return (Order)session.get(Order.class, id);
    }
 
    @SuppressWarnings("unchecked")
    public List<Order> listOrder() {
    	return sessionFactory.getCurrentSession().createQuery("from Order")
                .list();
    }
 
        public void removeOrder(Integer id) {
    	Order order = (Order) sessionFactory.getCurrentSession().load(
                Order.class, id);
        if (null != order) {
            sessionFactory.getCurrentSession().delete(order);
        }
    }
}
