package com.riad8321.flashcash.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
@ManyToOne
    private User from;
    @ManyToOne
    private User to;
    private Double amounteBeforeFee;
    private Double amountAfterFee;

}
