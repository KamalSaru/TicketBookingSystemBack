package com.diyo.TicketBookingSystem.service;

import com.diyo.TicketBookingSystem.entity.UserLogin;
import com.diyo.TicketBookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //post/save all User Login details-----------------
    public void saveRegisterUserLogin(UserLogin userLogin){
        userRepository.save(userLogin);
    }


    //User login verify-------------------------------
    public String findByEmailAndPassword( String email, String password){
        Optional<UserLogin> optionalUserLogin=this.userRepository.findByEmailAndPassword(email, password);
        if (optionalUserLogin.isPresent()){
            return "User login successfully.";
        } else {
            return "Invalid user email or password.";
        }
    }
}
