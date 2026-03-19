package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo2 {
public static void main(String[] args) throws Exception {
	
	int sr=4;
	String name="Vishal";
	int age=20;
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver class loaded successfully");
	
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_sql", "root", "Ryadav");
	PreparedStatement ps= con.prepareStatement("insert into student values("+sr+",'"+name+"',"+age+")");
	int i=ps.executeUpdate();
	
	if(i>0) {
		System.out.println("Success");
		
	}
	else {
		System.out.println("Fail");
	}
}
}
