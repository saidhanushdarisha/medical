package com.quickcare.QuickCare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickcare.QuickCare.Model.User;
import com.quickcare.QuickCare.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public boolean checkUser(String email, String password) {
        return repo.existsByUserEmailAndUserPassword(email, password);
    }

	public String getUserNameByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.getUserNameByEmail;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
		
	}
}
