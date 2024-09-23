package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.PersondaoImp;
import com.hospital_app.dto.Person;

public class PersonService
{
	public void savePerson(int eid, Person person)
	{
		PersondaoImp daoImp =new PersondaoImp();
		   Person person1 = daoImp.savePerson(eid, person);
			if(person1!=null)
			{
				System.out.println("Data Saved");
			}
			else
			{
				System.out.println("Unfortunately Data Not Saved");
			}
	}
	
	public  Person getPersonbyId(int pid)
	{
		PersondaoImp daoImp =new PersondaoImp();
         Person person1 = daoImp.getPersonId(pid);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public void deletePersonbyId(int pid)
	{
		PersondaoImp daoImp =new PersondaoImp();
		boolean flag = daoImp.deletePersonId(pid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	
	public Person updateMedorderbyid(int pid, Person person)
	{
		PersondaoImp daoImp =new PersondaoImp();
		Person person1 = daoImp.updatePersonId(pid, person);
		if(person1!=null)
		{
			return person1;
		}
		else
		{
			return null;
		}
	}
	public List<Person> getAllPerson()
	{
		PersondaoImp daoImp =new  PersondaoImp();
		List<Person> list=daoImp.getAllPerson();
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
		
	}
	public List<Person> getPersonbyGender(String gender)
	{
		PersondaoImp daoImp =new  PersondaoImp();
		List<Person> list=daoImp.getPersonByGender(gender);
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
		
	}
	public List<Person> getPersonbyAge(int age) 
	{
		PersondaoImp daoImp =new  PersondaoImp();
		List<Person> list=daoImp.getPersonByAge(age);
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
		
	}
	public List<Person> getPersonbyPhone(long phno)
	{
		PersondaoImp daoImp =new  PersondaoImp();
		List<Person> list=daoImp.getPersonByPhone(phno);
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
		
	}

}