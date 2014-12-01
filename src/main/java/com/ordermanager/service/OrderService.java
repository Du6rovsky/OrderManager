package com.ordermanager.service;

import java.util.List;
import com.ordermanager.domain.Order;

public interface OrderService {
	
	public void addOrder(Order order);
	
	public Order downloadOrder(Integer id);

	public List<Order> listOrder();
    
    public void removeOrder(Integer id);

}
