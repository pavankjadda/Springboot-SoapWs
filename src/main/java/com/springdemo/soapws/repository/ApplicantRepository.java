package com.springdemo.soapws.repository;

import com.springdemo.soapws.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public interface ApplicantRepository extends JpaRepository<Applicant, Long>
{

    Optional<Applicant> findByAlienNumber(String alienReg);

    List<Applicant> findAllByDob(Date dob);

    Optional<Applicant> findByIdAndDobAndAlienNumber(Long aid, Date dob,
                                                     String alienReg);

    Optional<Applicant> findByDobAndAlienNumber(Date dob, String alienReg);

    List<Applicant> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContaining(
            String name, String name2, String name3);

}
