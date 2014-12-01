package com.ordermanager.dao;

import java.util.List;
import com.ordermanager.domain.Order;

public interface OrderDAO {
	
	public void addOrder(Order order);
	
	public Order downloadOrder(Integer id);

	public List<Order> listOrder();
    
    public void removeOrder(Integer id);
	
}
