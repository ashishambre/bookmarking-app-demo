package com.ashish.thrillio.dao;

import com.ashish.thrillio.DataStore;
import com.ashish.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
