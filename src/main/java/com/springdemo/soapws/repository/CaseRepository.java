package com.springdemo.soapws.repository;

import com.springdemo.soapws.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CaseRepository extends JpaRepository<Case, Long>
{

}
