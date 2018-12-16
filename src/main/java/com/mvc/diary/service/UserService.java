package com.mvc.diary.service;

import com.mvc.diary.models.*;

public interface UserService {
	User findById(String userid);
	User findByUserName (String username);
	boolean insertUser(User user);
	void deleteUser (String userid);
	void updateUser (User user);
	boolean isDuplicate (User user);
}
