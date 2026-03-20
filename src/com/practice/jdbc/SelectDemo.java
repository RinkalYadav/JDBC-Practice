package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo  {
public static void main(String[] args)throws Exception {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_sql","root","Ryadav");
	
	PreparedStatement ps= con.prepareStatement("select * from student");
	ResultSet rs=ps.executeQuery();
	
	while(rs.next()) {
		int id=rs.getInt("id");
		System.out.println(id);
		
		String name=rs.getString("name");
		System.out.println(name);
		
		int age=rs.getInt("age");
		System.out.println(age);
		
		System.out.println("-----------------------");
	}
	con.close();
}
}
