package com.diyo.TicketBookingSystem.repository;

import com.diyo.TicketBookingSystem.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserLogin, Long> {

    //To check the validate email and password
    public Optional<UserLogin>findByEmailAndPassword(String email, String password);
}
