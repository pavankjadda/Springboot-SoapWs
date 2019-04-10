package com.springdemo.soapws.repository;

import com.springdemo.soapws.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long>
{

}
