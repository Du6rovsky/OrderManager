package com.ordermanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ordermanager.dao.OrderDAO;
import com.ordermanager.domain.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;	
	
    @Transactional
	public Order downloadOrder(Integer id) {
		return orderDAO.downloadOrder(id);
	}

    @Transactional
	public List<Order> listOrder() {
		return orderDAO.listOrder();
	}

    @Transactional
	public void addOrder(Order order) {
		orderDAO.addOrder(order);		
	}

    @Transactional
	public void removeOrder(Integer id) {
		orderDAO.removeOrder(id);
	}
   
}
