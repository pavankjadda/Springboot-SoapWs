package com.springdemo.soapws.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * The type Case.
 */
@Entity
@Table(name = "ccd_case")
@Data
public class Case
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "case_status")
    private String caseStatus;

    @Column(name = "provisional")
    private String provisional;

    @Column(name = "derogatory_info")
    private String derogatoryInfo;

    @Column(name = "finger_prints")
    private String fingerPrints;

    @Column(name = "post_clearance")
    private String postClearance;

    @Column(name = "fbi_clearance")
    private String fbiClearance;

    @Column(name = "interview_status")
    private String interviewStatus;

    @Column(name = "interview_appointment")
    private String interviewAppointment;


    /*
        One Case can have multiple applicants
     */
    @OneToMany(mappedBy = "applicantCase", fetch = FetchType.LAZY)
    private List<Applicant> applicants;

    /**
     * Instantiates a new Case.
     */
    public Case()
    {
    }

    /**
     * Instantiates a new Case.
     *
     * @param id         the id
     * @param caseStatus the case status
     */
    public Case(Long id, String caseStatus)
    {
        super();
        this.id = id;
        this.caseStatus = caseStatus;
    }

    /**
     * Instantiates a new Case.
     *
     * @param caseStatus the case status
     */
    public Case(String caseStatus)
    {
        super();
        this.caseStatus = caseStatus;
    }

    @Override
    public String toString()
    {
        return "Case{" +
                "id=" + id +
                ", caseStatus='" + caseStatus + '\'' +
                ", provisional='" + provisional + '\'' +
                ", derogatoryInfo='" + derogatoryInfo + '\'' +
                ", fingerPrints='" + fingerPrints + '\'' +
                ", postClearance='" + postClearance + '\'' +
                ", fbiClearance='" + fbiClearance + '\'' +
                ", interviewStatus='" + interviewStatus + '\'' +
                ", interviewAppointment='" + interviewAppointment + '\'' +
                '}';
    }
}
