package com.sg.client;

import java.util.function.Function;

public class FunctionalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer, Double> f1 = new Function<Integer, Double>(){
			@Override
			public Double apply(Integer t)
			{
				return t/2.0;
			}
		};
		System.out.println(f1.apply(5));
		
		//Hava 8 lambda functions
		Function <Integer, Double> f2 = (Integer t) ->{
			return t/2.0;
		};
		Function <Integer, Double> f3 = (t) -> t/3.0;
		System.out.println(f2.apply(4));
		System.out.println(f3.apply(8));
		
	}

}
