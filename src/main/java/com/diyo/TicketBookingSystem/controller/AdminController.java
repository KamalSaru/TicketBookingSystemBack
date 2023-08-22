package com.diyo.TicketBookingSystem.controller;


import com.diyo.TicketBookingSystem.entity.AdminLogin;
import com.diyo.TicketBookingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/admin")
public class AdminController {
    @Autowired

    private AdminService adminService;

    //Register/post the users username and password-------------------
    @PostMapping("/register")
    public ResponseEntity<String> saveRegisterAdminLogin(@RequestBody AdminLogin adminLogin){
        this.adminService.saveRegisterAdminLogin(adminLogin);
        return ResponseEntity.ok("Admin login registered successfully!!");
    }

    //login verify----------------------------
    @PostMapping("/login")
    public ResponseEntity<String>validateAdmin(@RequestBody AdminLogin adminLogin) {
        this.adminService.findByEmailAndPasswordAndPinCode(adminLogin.getEmail(), adminLogin.getPassword(), adminLogin.getPinCode());
        return ResponseEntity.ok(adminService.findByEmailAndPasswordAndPinCode(adminLogin.getEmail(), adminLogin.getPassword(), adminLogin.getPinCode()));
    }
}
