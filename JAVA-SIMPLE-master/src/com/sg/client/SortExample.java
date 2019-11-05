package com.sg.client;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"James", "Brass", "Top", "Window", "Bad"};
		Arrays.sort(names, (o1, o2)->(o1.length()-o2.length()));
		
		for(String A: names)
		{
			System.out.println(A);
		}

	}

}
