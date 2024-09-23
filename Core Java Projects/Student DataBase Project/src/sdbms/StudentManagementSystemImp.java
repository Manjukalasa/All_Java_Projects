package sdbms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.SortStudentAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class StudentManagementSystemImp implements StudentManagementSystem 
{
	Scanner sc=new Scanner(System.in);
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent() 
	{
		System.out.println("Enter Student Age:");
		int age=sc.nextInt();
		System.out.println("Enter Student Name:");
		String name=sc.next();
		System.out.println("Enter Student Marks:");
		int marks=sc.nextInt(); 

		Student std=new Student(age,name,marks);
		db.put(std.getId(),std);
		System.out.println("Student record added Successfully");
		System.out.println("Student Id is: "+std.getId());
	}

	@Override
	public void displayStudent()
	{
		System.out.println("Enter Student Id:");
		//	String id=sc.next().toUpperCase();
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id); // getting Student Object
			System.out.println("Student Details are as Follows:");
			System.out.println("Student Id: "+std.getId());
			System.out.println("Student Age: "+std.getAge());
			System.out.println("Student Name: "+std.getName());
			System.out.println("Student Marks: "+std.getMarks());
		}
		else
		{
			try
			{
				String message="Student with the id "+id+" is not Found..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() 
	{
		if(db.size()!=0)
		{
			System.out.println("Student Details are as Follows: ");
			System.out.println("--------------------------------");
			Set<String> keys=db.keySet();// we will get JSP101,JSP102,JSP103
			for(String key:keys)
			{
				Student std=db.get(key);
				System.out.println(std); // Both are Same
				//System.out.println(db.get(key));
			}
		}
		else
		{
			try
			{
				String message="Student Data base is Empty,Nothing to display..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeStudent() 
	{
		System.out.println("Enter Student Id:");
		String id=sc.next();
		id=id.toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Student Record Found:");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Studednt Record Deleted Sucessfully..!");
		}
		else
		{
			try
			{
				String message="Student with the id "+id+" is not Found..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents()
	{
		if(db.size()!=0)
		{
			System.out.println("Available Student Record "+db.size());
			db.clear();
			System.out.println("All the Student Records Deleted Successfully..!");
		}
		else
		{
			try
			{
				String message="Student Data base is Empty,Nothing to Delete..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent()
	{

		System.out.println("Enter Student Id:");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Student std=db.get(id);
			System.out.println(std);
			System.out.println("1:update Age\n2:upadate name\3:update Marks");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				System.out.println("Enter Student Age:");
				std.setAge(sc.nextInt());
				System.out.println("Age updated Successfully");
				break;
			case 2: 
				System.out.println("Enter Student Name:");
				std.setName(sc.next());
				System.out.println("Name updated Successfully");
				break;
			case 3:
				System.out.println("Enter Student Marks:");
				std.setMarks(sc.nextInt());
				System.out.println("Marks updated Successfully");
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
			}
		}
		else
		{
			try
			{
				String message="Student with the id "+id+" is not Found..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudents() 
	{		
		System.out.println("No of Student Records: "+db.size());
	}

	@Override
	public void sortStudents() 
	{
		if(db.size()>=2)
		{
			List<Student> list=new ArrayList<Student>();  // s1 s2
			Set<String> keys= db.keySet(); // JSP101 JSP102
			for(String key:keys)
			{
				list.add(db.get(key)); // getting & adding student object in Arraylist
			}
			System.out.println("1:Sort Student By Id:\n2:Sort Student By Age:\n3:Sort Student By Name:\n4:Sort Student By Marks:");
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				Collections.sort(list,new SortStudentById());
				display(list);  // calling helper methos
				break;
			case 2: 
				Collections.sort(list,new SortStudentAge());
				display(list);
				break;
			case 3:
				Collections.sort(list,new SortStudentByName());
				display(list);
				break;
			case 4:
				Collections.sort(list,new SortStudentByMarks());
				display(list);
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
			}
		}
		else
		{
			try
			{
				String message="No Sufficient Student Record to sort..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	private static void display(List<Student> list) // helper methos
	{
		for(Student s:list)
		{
			System.out.println(s);
		}
	}
	@Override
	public void getStudentWithHighestMarks()
	{
		if(db.size()>=2)
		{
			List<Student> list=new ArrayList<Student>();  // s1 s2
			Set<String> keys= db.keySet(); // JSP101 JSP102
			for(String key:keys)
			{
				list.add(db.get(key)); // getting & adding student object in Arraylist
			}
			Collections.sort(list,new SortStudentByMarks());	
			System.out.println(list.get(list.size()-1));  // getting higthest mark student
		}
		else
		{
			try
			{
				String message="No Sufficient Student Record to Compare..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}	
		}
	}

	@Override
	public void getStudentWithLowestMarks()
	{
		if(db.size()>=2)
		{
			List<Student> list=new ArrayList<Student>();  // s1 s2
			Set<String> keys= db.keySet(); // JSP101 JSP102
			for(String key:keys)
			{
				list.add(db.get(key)); // getting & adding student object in Arraylist
			}
			Collections.sort(list,new SortStudentByMarks());	
			System.out.println(list.get(0));  // getting Lowest mark student
		}
		else
		{
			try
			{
				String message="No Sufficient Student Record to Compare..!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}	
		}
	}

}
