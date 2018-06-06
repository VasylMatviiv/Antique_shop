package com.cybo.service;

import com.cybo.entity.UserEntity;

public interface UserService {
	
void saveUser(UserEntity entity);
	
	void updateUser(UserEntity entity);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);

}
