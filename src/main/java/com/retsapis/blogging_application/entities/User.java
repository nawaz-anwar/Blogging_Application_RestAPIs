package com.retsapis.blogging_application.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_data")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int id;

    @Column(name = "userName", nullable = false, length = 100)
    private String userName;

    @Column(unique = true)
    private String userEmail;

    private String userPassword;

    private String userAbout;
}
