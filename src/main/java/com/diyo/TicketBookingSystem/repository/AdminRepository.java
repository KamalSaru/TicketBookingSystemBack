package com.diyo.TicketBookingSystem.repository;

import com.diyo.TicketBookingSystem.entity.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface AdminRepository extends JpaRepository<AdminLogin, Long> {

    //Admin login option-----------
    public Optional<AdminLogin> findByEmailAndPasswordAndPinCode(String email, String password, Integer pinCode);
}
