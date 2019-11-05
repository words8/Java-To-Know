package com.sg.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Covariant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> iList = Arrays.asList(2, 66, 88, 24, 67);
		List<String> sList = Arrays.asList("Hello", "World", "ggwp","Can't win this");
		print(iList);
		print(sList);
		List<String> copystr = new ArrayList<>();
		List<Integer> copyint = new ArrayList<>();
		copy(iList, copyint);
		copy(sList, copystr);
		print(copyint);
		
	}
	private static <T> void copy(List<? extends T> source, List<? super T> dest)
	{
		for(T o : source)
		{
			dest.add(o);
		}
	}
	private static void print(List<?> list)
	{
		for(Object o: list)
		{
			System.out.println(o);
		}
	}
}

