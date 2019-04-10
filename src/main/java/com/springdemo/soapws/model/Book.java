package com.springdemo.soapws.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "number_of_pages")
    private String numberOfPages;

    @Column(name = "cost")
    private Double cost;

    @OneToMany
    private Author author;

}
