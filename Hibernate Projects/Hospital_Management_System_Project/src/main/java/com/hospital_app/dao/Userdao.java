package com.hospital_app.dao;

import java.util.List;
import com.hospital_app.dto.User;

public interface Userdao 
{
	 public User saveUser(User user);
	 public User getUserId(int uid);
	 public boolean  deleteUserId(int uid);
	 public User updateUser(int uid,User user);
	 public List<User> getAllUser();
	 public List<User> getUserByRole();
}
