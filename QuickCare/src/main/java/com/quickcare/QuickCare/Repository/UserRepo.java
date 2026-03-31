package com.quickcare.QuickCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quickcare.QuickCare.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    String getUserNameByEmail = null;

	boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);
}
