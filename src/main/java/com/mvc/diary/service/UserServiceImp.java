/**
 * 
 */
package com.mvc.diary.service;

import org.springframework.stereotype.Service;

import com.mvc.diary.models.User;
import com.mvc.diary.utils.Connection;


/**
 * @author mchi0002
 *
 */
@Service("userService")
public class UserServiceImp implements UserService {

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.UserService#findById(java.lang.String)
	 */
	
	@Override
	public User findById(String userid) {
		// TODO Auto-generated method stub
		
		Connection col = new Connection();
		User user = (User) col.search("user", userid, Boolean.FALSE);
		user.printValues();
		return user;
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.UserService#findByUserName(java.lang.String)
	 */
	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		Connection col = new Connection();
		System.out.println("In FindbyUsername  " + username);
		User user = (User) col.search("user", username, Boolean.TRUE);
		if (user !=null) {user.printValues();}
		return user;
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.UserService#insertUser(com.mvc.diary.models.User)
	 */
	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		user.printValues();
		if (findByUserName(user.getUsername())== null) {
			Connection col = new Connection();
			col.insert("user", user);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.UserService#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String userid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.UserService#updateUser(com.mvc.diary.models.User)
	 */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.mvc.diary.service.UserService#isDuplicate(com.mvc.diary.models.User)
	 */
	@Override
	public boolean isDuplicate(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
