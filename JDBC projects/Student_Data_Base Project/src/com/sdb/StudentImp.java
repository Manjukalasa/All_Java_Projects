package com.sdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImp implements StudentInteface {

	Scanner sc=new Scanner(System.in);

	@Override
	public void savestudent() {
		System.out.println("Enter Student Id");
		int id=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next();
		System.out.println("Enter Student Age");
		int age=sc.nextInt();
		System.out.println("Enter Student Marks");//78,85,100
		double marks=sc.nextDouble();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDBProject","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,age);
			preparedStatement.setDouble(4,marks);
			preparedStatement.execute();
			connection.close();
			System.out.println("Student Data Saved");

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override

	public void deletestudent() {
		System.out.println("Enter Student Id");
		int id=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDBProject","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("Delete from student where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			connection.close();
			System.out.println("Student Data Deleted");

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updatestudent() {
		System.out.println("Enter Student Id");
		int id=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDBProject","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set name=? where id=?");
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2, id);
			preparedStatement.execute();
			connection.close();
			System.out.println("Student Data Updated");

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getstudentbyname() {
		System.out.println("Enter Student Marks");
		double marks=sc.nextDouble();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDBProject","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student where marks=?");

			preparedStatement.setDouble(1,marks);

			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("The student id: "+resultSet.getInt(1));
				System.out.println("The student name: "+resultSet.getString(2));
				System.out.println("The student Age: "+resultSet.getString(3));
				System.out.println("The student Marks: "+resultSet.getString(4));
				System.out.println("****************************************************");
			}
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public void gerAllstudents() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDBProject","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("The student id: "+resultSet.getInt(1));
				System.out.println("The student name: "+resultSet.getString(2));
				System.out.println("The student website: "+resultSet.getInt(3));
				System.out.println("The student location: "+resultSet.getDouble(4));
				System.out.println("****************************************************");
			}
			connection.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
