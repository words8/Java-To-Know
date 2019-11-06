package com.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sg.dao.CustomerDao;
import com.sg.dao.OrderDao;
import com.sg.dao.ProductDao;
import com.sg.entity.Customer;
import com.sg.entity.Order;
import com.sg.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public Customer getCustomer(String email)
	{
		return customerDao.getOne(email);
	}
	
	@Transactional
	public void placeOrder(Order order)
	{
		orderDao.save(order);
	}
	
	public List<Order> getOrders()
	{
		return orderDao.findAll();
	}
	
	@Transactional
	public void addProduct(Product P)
	{
		productDao.save(P);
	}
	public List<Product> getProducts(){
		return productDao.findAll();
	}
	public Product getProduct(int id)
	{
		return productDao.findById(id).get();
	}
	public List<Product> getByPrice(double price){
		return productDao.getByPrice(price);
	}
	
}
