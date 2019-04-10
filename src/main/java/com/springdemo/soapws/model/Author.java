package com.springdemo.soapws.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
public class Author
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

}
