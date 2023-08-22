package com.diyo.TicketBookingSystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.List;

@Table(name="customer_Details")
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//Airbus Ticket Booking
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ID_generator")
    @SequenceGenerator(name="ID_generator", sequenceName = "Customer_sequence")
    @Column(name="customer_ID")
    private Long customerID;
    @NotBlank(message = "Please provide first name")
    private String firstName;
    private String lastName;
    private String address;
    @Column(name="date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    //@CreationTimestamp
    private String dob;
    private String gender;
    @Column(name="phone_number")
    private Long phone;
    @Column(name="email_address")
    @Email(message = "Please provide email address")
    private String email;
    private String active;
    private String status;

    //Join two table data
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_fk_ID", referencedColumnName = "customer_ID")
    private List<Ticket>ticketList;
}
