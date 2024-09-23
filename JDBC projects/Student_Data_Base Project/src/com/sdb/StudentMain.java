package com.sdb;

import java.util.Scanner;

public class StudentMain
{
	public static void main(String[] args) {
		StudentInteface si=new StudentImp();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("====================================New Line===========================================================");
			System.out.println("1:Add Student\n2:Delete Student\n3:Update Student\n4:Get Student By marks\n5:Get All Students");
			System.out.println("Enter your Choice 1 To 5 only");
			int choice= sc.nextInt();
			switch(choice)
			{
			case 1:si.savestudent();
			break;

			case 2:si.deletestudent();
			break;

			case 3:si.updatestudent();
			break;

			case 4:si.getstudentbyname();
			break;

			case 5:si.gerAllstudents();
			break;

			default: System.out.println("Invalid Choice");
			break;
			}
		}
	}
}
