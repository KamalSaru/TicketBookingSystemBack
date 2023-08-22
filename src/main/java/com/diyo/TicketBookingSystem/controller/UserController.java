package com.diyo.TicketBookingSystem.controller;



import com.diyo.TicketBookingSystem.entity.UserLogin;
import com.diyo.TicketBookingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/user")
public class UserController {
    @Autowired

    private UserService userService;

    //Register/post the users username and password-------------------
    @PostMapping("/register")
    public ResponseEntity<String>saveRegisterUserLogin(@RequestBody UserLogin userLogin){
        this.userService.saveRegisterUserLogin(userLogin);
        return ResponseEntity.ok("User login registered successfully!!");
    }


    //User login verify----------------------------
    @PostMapping("/login")
    public ResponseEntity<String>validateUser(@RequestBody UserLogin userLogin) {
        this.userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
        return ResponseEntity.ok(userService.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword()));
    }

}
