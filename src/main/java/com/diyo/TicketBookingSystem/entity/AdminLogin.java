package com.diyo.TicketBookingSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminLogin {
    //AdminLogin authorized check all customers account
    //User can log in their account
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="admin_id_generator")
    @SequenceGenerator(name="admin_id_generator", sequenceName = "admin_id_sequence")

    @Column(name="admin_ID")
    private Long adminID;

    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String department;
    private String position;

    @NotBlank(message="Please provide email address.")
    private String email;

    //@Min(value=6, message="Minimum six character.")
    //@Max(value=10, message="Maximum ten character.")
    private String password;

    //@Min(value=6, message="Minimum six digit.")
    @Column (name="pin_code")
    private Integer pinCode;
}
