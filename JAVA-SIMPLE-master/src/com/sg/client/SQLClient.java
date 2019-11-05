package com.sg.client;

import com.sg.entity.Book;
import com.sg.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Create_SQL = SQLUtil.getCreateStatement(Book.class);
		System.out.println(Create_SQL);
		Book b1 = new Book(34, "Alchemist", 450.10);
		System.out.println(SQLUtil.getInsertSQl(b1));
	}

}
