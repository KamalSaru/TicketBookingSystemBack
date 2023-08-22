package com.diyo.TicketBookingSystem.service;


import com.diyo.TicketBookingSystem.entity.AdminLogin;
import com.diyo.TicketBookingSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AdminService {
    @Autowired

    private AdminRepository adminRepository;

    //post/save all Admin Login details-----------------
    public void saveRegisterAdminLogin(AdminLogin adminLogin) {
        adminRepository.save(adminLogin);
    }

    //Admin login verify-------------------------------
    public String findByEmailAndPasswordAndPinCode( String email, String password, Integer pinCode){
        Optional<AdminLogin>administration=this.adminRepository.findByEmailAndPasswordAndPinCode(email, password, pinCode);
        if (administration.isPresent()){
            return "Admin login successfully.";
        } else {
            return "Invalid admin email or password or pinCode.";
        }
    }
}
