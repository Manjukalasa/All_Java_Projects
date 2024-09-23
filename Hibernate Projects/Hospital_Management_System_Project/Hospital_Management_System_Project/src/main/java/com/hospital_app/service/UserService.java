package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.imp.UserdaoImp;
import com.hospital_app.dto.User;

public class UserService
{
	public void saveUser(User user)
	{
		UserdaoImp daoImp =new  UserdaoImp();
		User user1 = daoImp.saveUser(user);
		if(user1!=null)
		{
			System.out.println("Data Saved");
		}
		else
		{
			System.out.println("Unfortunately Data Not Saved");
		}
	}

	public  User getuserbyId(int uid)
	{
		UserdaoImp daoImp =new  UserdaoImp();
		User user1 = daoImp.getUserId(uid);
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}
	}
	public void deleteUserbyId(int uid)
	{
		UserdaoImp daoImp =new  UserdaoImp();
		boolean flag = daoImp.deleteUserId(uid);
		if(flag)
		{
			System.out.println("data deleted");
		}
		else
		{
			System.out.println("data not found");
		}
	}
	public User updateUserbyid(int uid, User user)
	{
		UserdaoImp daoImp =new  UserdaoImp();
		User user1= daoImp.updateUser(uid, user);
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}
		
	}
	public List<User> getAllUser()
	{
		UserdaoImp daoImp =new  UserdaoImp();
		List<User> list=daoImp.getAllUser();
			if(list!=null)
			{
			
			return list;
		}
		else
		{
			return null;
		}
		
	}
	public List<User> getuserbyRole(String role)
	{
		UserdaoImp daoImp =new  UserdaoImp();
		List<User> list=daoImp.getUserByRole();
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