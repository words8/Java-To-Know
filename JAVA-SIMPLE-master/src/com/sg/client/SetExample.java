package com.sg.client;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.sg.entity.Article;
import com.sg.entity.Product;
public class SetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Product> products = new HashSet<>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
	    products.add(new Product(224, "iPhone", 98000.00, "mobile"));
	    products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
	    products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
	    products.add(new Product(912, "One Plus", 32000.00, "mobile"));
	    products.add(new Product(88, "HP Printer", 19000.00, "computer"));
        
        for(Product p:products) {
        	System.out.println(p);
        }
        
        
	}

}
