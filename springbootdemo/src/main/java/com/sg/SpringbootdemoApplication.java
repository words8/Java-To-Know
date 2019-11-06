package com.sg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sg.entity.Customer;
import com.sg.entity.Item;
import com.sg.entity.Order;
import com.sg.entity.Product;
import com.sg.service.OrderService;

@SpringBootApplication
public class SpringbootdemoApplication implements CommandLineRunner {

	@Autowired
	private OrderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
//		insertProducts();
//		getProducts();
//		placeOrder();
		
		
	}
	
	private void placeOrder() {
		// TODO Auto-generated method stub
		Order o = new Order();
		Product p1 = service.getProduct(1);
		Product p2 = service.getProduct(3);
		
		Item i1 = new Item();
		i1.setProduct(p1);
		i1.setQty(2);
		i1.setAmount(p1.getPrice()*i1.getQty());
		
		Item i2 = new Item();
		i2.setProduct(p2);
		i2.setQty(2);
		i2.setAmount(p2.getPrice()*i2.getQty());
		
		Customer c = new Customer();
		c.setEmail("a@sg.com");
		o.setCustomer(c);
		
		o.getItems().add(i1);
		o.getItems().add(i2);
		o.setTotal(i1.getAmount()+i2.getAmount());
		
		service.placeOrder(o);
	}
	private void getProducts() {
		// TODO Auto-generated method stub
		List<Product> prds = service.getByPrice(1_00_000);
		for(Product p :prds)
		{
			System.out.println(p);
		}
		
	}
	private void insertProducts() {
		Product p1 = new Product(0, "iPhone11 Pro", 120000.00, "mobile");
		Product p2 = new Product(0, "HP Spectre", 135000.00, "computer");
		Product p3 = new Product(0, "Sony Bravia", 90000.00, "tv");
		
		service.addProduct(p1);
		service.addProduct(p2);
		service.addProduct(p3);
		
	}

}
