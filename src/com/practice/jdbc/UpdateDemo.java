package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDemo {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter new age to update");
	int age=sc.nextInt();
	System.out.println("Enter the id where you want to change");
	int id=sc.nextInt();
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_sql","root","Ryadav");
	PreparedStatement ps= con.prepareStatement("update student set age=? where id=?");
	
	ps.setInt(1,age);
	ps.setInt(2, id);
	
	int n=ps.executeUpdate();
	
	if(n>0) {
		System.out.println("update successfully ");
		
	}
	else {
		System.out.println("Not updated");
	}
	
}
}
