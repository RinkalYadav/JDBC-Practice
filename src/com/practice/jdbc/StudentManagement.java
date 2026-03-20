package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentManagement {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_sql","root","Ryadav");
	while(true) {
		

	System.out.println("============Student Management System===========");
	System.out.println("1. Add Student");
	System.out.println("2. View Student");
	System.out.println("3. Update Student");
	System.out.println("4. Delete Student");
	System.out.println("5. Exit");
	
	System.out.println("Enter your choice");
	int ch=sc.nextInt();
	if(ch < 1 || ch > 5) {
	    System.out.println("Invalid choice");
	    continue;
	}
	else if(ch==1) {
			System.out.println("Enter the id of student ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name of student");
			String name=sc.nextLine();
			System.out.println("Enter the age of studnet");
			int age=sc.nextInt();
			PreparedStatement ps= con.prepareStatement("insert into student values(?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			
			int n=ps.executeUpdate();
			
			if(n>0) {
				System.out.println("Student added successfully");
				
			}
			else {
				System.out.println("Student not added");
			}
			
		}
	
	else if(ch==2) {
		PreparedStatement ps= con.prepareStatement("select * from student");
		ResultSet rs= ps.executeQuery();
		System.out.println("ID		NAME		AGE");
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			int age=rs.getInt("age");			
			System.out.println(id+"		"+name+"		"+age);
						
		}
	}
	
	else if(ch==3) {
		System.out.println("Enter the new age");
		int age=sc.nextInt();
		System.out.println("Enter the student id to update his age");
		int id=sc.nextInt();
		PreparedStatement ps= con.prepareStatement("update student set age=? where id=?");
		ps.setInt(1,age);
		ps.setInt(2,id);
		
		int n=ps.executeUpdate();
		if(n>0) {
			System.out.println("Student's age updated successfully");
		}
		else {
			System.out.println("Student's age not updated");
		}
	}
	
	else if(ch==4) {
		System.out.println("Enter the student id whose data you want to delete");
		int id=sc.nextInt();
		PreparedStatement ps= con.prepareStatement("delete from student where id=?");
		ps.setInt(1, id);
		
		int n=ps.executeUpdate();
		if(n>0) {
			System.out.println("Studnet's data deleted successfully");
			}
		else {
			System.out.println("Student's data not deleted");
		}
	}
	else if(ch==5) {
	    System.out.println("Exiting...");
	    break;
	}
	
	
}
	con.close();
	sc.close();
}
}
