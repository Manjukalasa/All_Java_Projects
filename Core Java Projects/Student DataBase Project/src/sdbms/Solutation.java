package sdbms;

import java.util.Scanner;
import customexception.InvalidChoiceException;
public class Solutation 
{
	public static void main(String[] args) 
	{
		System.out.println("Well come To Student DataBase System");
		System.out.println("------------------------------------");
		Scanner sc=new Scanner(System.in);
		StudentManagementSystem sms=new StudentManagementSystemImp();  // upcating
		while(true)
		{
			//Menu Driven Program
			System.out.println("1.Add Student\n2.Display Student\n3.Display All Students\n4.Remove Student\n5.RemoveAllStudents\n"
			+"6.update Student\n7.count Students\n8.sort Students\n9.get Student With Highest Marks\n10.get Student With Lowest Marks\n11.Exit");
			System.out.println("Enter Your Choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudents();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.getStudentWithHighestMarks();
				break;
			case 10:
				sms.getStudentWithLowestMarks();
				break;
			case 11:
				System.out.println("Thank You...!");
				System.exit(0);
				break;
			default:
				try
				{
					throw new InvalidChoiceException("Invalid Choice..!");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}  // end of sitch case
			System.out.println("-------------------------------------");
		} // end of while loop
	} // end of main Methos
}  // end of class
