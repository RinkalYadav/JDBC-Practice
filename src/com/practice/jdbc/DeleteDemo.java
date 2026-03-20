package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDemo {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the id which row you want to delete");
	int id=sc.nextInt();
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_sql","root","Ryadav");
	
	PreparedStatement ps= con.prepareStatement("delete from student where id=?");
	ps.setInt(1,id);
	
	int count=ps.executeUpdate();
	if(count>0) {
		System.out.println("Deleted successfully ");
		
	}
	else {
		System.out.println("Not deleted");
	}
	con.close();
}
}
