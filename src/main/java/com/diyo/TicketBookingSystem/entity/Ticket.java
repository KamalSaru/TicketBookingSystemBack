package com.diyo.TicketBookingSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;


@Data
@Table(name="ticket_details")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ID_generator")
    @SequenceGenerator(name="ID_generator", sequenceName = "Ticket_sequence")
    @Column(name="Ticket_ID")
    private Long ticketID;
    private Integer travelers;
    private String statusClass;
    private String flyingFrom;
    private String flyingTo;

    //@JsonFormat(pattern="yyyy-MM-dd")
    //private Date departureDate;
    private String departureDate;

    //@JsonFormat(pattern="HH:mm")
    private String departureTime;
    private String airline;
    private String flightNumber;

    @Column(name="ticket_price")
    //@NotBlank(message="Please provide price.")
    private Float ticketPrice;
    private Float couponDiscount;
    private Float tax;

    //@Formula(value="ticketPrice-couponDiscount+tax")
    //@Transient  --create formula and auto column
    private Float finalCost;

    //@JsonFormat(pattern="yyyy-MM-dd")
    //@CreationTimestamp
    private String purchaseDate;
}
