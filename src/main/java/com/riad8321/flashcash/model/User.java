package com.riad8321.flashcash.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 3, max = 50)
    private String firstName;
    @Size(min = 3, max = 50)
    private String lastName;
    @Column(unique = true)
    @NotBlank
    @Email
    private String email;
    @NotBlank
//    @Size(min = 3, max = 20)
    private String password;
    @ManyToMany
    private List<Link> links;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAccount account;

}
