package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDemo3 {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the id Of student ");
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the name of the student");
	String name=sc.nextLine();
	System.out.println("Enter the age of the student");
	int age=sc.nextInt();
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver class loaded successfully");
	
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_sql", "root", "Ryadav");
	PreparedStatement ps= con.prepareStatement("insert into student values(?,?,?)");
	ps.setInt(1,id);
	ps.setString(2,name);
	ps.setInt(3, age);
	int i=ps.executeUpdate();
	
	if(i>0) {
		System.out.println("Success");
		
	}
	else {
		System.out.println("Fail");
	}
}
}
