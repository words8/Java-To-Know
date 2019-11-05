package com.sg.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sg.entity.Product;

public class ListExample {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
	    products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
	    products.add(new Product(224, "iPhone", 98000.00, "mobile"));
	    products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
	    products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
	    products.add(new Product(912, "One Plus", 32000.00, "mobile"));
	    products.add(new Product(88, "HP Printer", 19000.00, "computer"));
	    
//	    Collections.sort(products, (p1,p2)-> Double.compare(p1.getPrice(),p2.getPrice()));
//	    
//	    for(Product p: products)
//		{
//			System.out.println(p);
//		}
	    //@formatter:off
	    products.stream().
	    filter(p->p.getCategory().equals("computer")).
	    forEach(p->System.out.println(p));
	    
	    products.stream().
	    map(p->p.getName()).
	    forEach(System.out::println);
	    
	    System.out.println( 
	    		products.stream().
	    		map(p->p.getPrice()).
	    		reduce(0.0, (acc, val) -> acc + val));
	    
	    Map<String, List<Product>> map = products.stream()
	    		.collect(Collectors.groupingBy(p -> p.getCategory()));
	    
	    map.forEach((k,v) -> {
	    	System.out.println(k);
	    	v.forEach((p)->System.out.println(p));
	    });
	    
	    DoubleSummaryStatistics stats = products.stream()
	    		.collect(Collectors.summarizingDouble(p->p.getPrice()));
	    
	    System.out.println(stats.getSum());
	    System.out.println(stats.getAverage());
	    System.out.println(stats.getMax());
	    //@formatter:on
	    
	}
}
