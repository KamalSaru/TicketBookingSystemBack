package com.diyo.TicketBookingSystem.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserLogin {
    //User can log in their account
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="user_id_generator")
    @SequenceGenerator(name="user_id_generator", sequenceName = "user_id_sequence")
    private Long userID;
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    //@NotBlank(message="Please provide email address.")
    private String email;
    //@Min(Value=6, message="Minimum six character.")
    //@Max(value=10, message="Maximum ten character.")
    private String password;
}
