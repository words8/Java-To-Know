package com.sg.util;

import com.sg.column;
import com.sg.Table;
import java.lang.reflect.Method;

public class SQLUtil {
	
	public static String getCreateStatement(Class<?> clazz) {
		//always use string builders to create strings
		// String literal usage ads the object to pool and it is not garbage collected.
		//Choose between StringBuffer(ThreadSafe) and StringBuilder(Not Thread Safe). 

		StringBuilder builder = new StringBuilder();
		Table t = clazz.getAnnotation(Table.class);
		if(t != null) {
			builder.append("Create table ");
			builder.append(t.name());
			builder.append("(");
			
			Method[] methods = clazz.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				Method m = methods[i];
				if(m.getName().startsWith("get"))
				{
					column c = m.getAnnotation(column.class);
					if(c!=null) {
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(",");
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","),')');

		}
		return builder.toString();
		
	}
	public static String getInsertSQl(Object obj) {
		StringBuilder builder = new StringBuilder();
		Table t= obj.getClass().getAnnotation(Table.class);
		if(t != null)
		{
			builder.append("INSERT INTO ");
			builder.append(t.name());
			builder.append(" VALUES (");
			Method[] methods = obj.getClass().getDeclaredMethods();
			for(Method m : methods)
			{
				if(m.getName().startsWith("get")) {
					column c = m.getAnnotation(column.class);
					if(c!=null) {
						try {
							Object ret = m.invoke(obj);
							if(ret instanceof String) {
								builder.append("'");
								builder.append(ret);
								builder.append("'");
							}
							else builder.append(ret);
							builder.append(",");
						}
						catch(Exception e) {e.printStackTrace();}
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","),')');
		}
		return builder.toString();
	}
}

