package com.springdemo.soapws.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * The type Applicant.
 */
@Entity
@Table(name = "ccd_applicant")
@Data
public class Applicant
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private java.sql.Date dob;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_place_country_code")
    private String birthPlaceCountryCode;

    @Column(name = "ident_finger_print_id")
    private Long identFingerPrintId;

    @Column(name = "nationality_code")
    private String nationalityCode;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "visa_control_number")
    private String visaControlNumber;

    @Column(name = "alien_number")
    private String alienNumber;

    @Column(name = "site_code")
    private String siteCode;


    @Column(name = "pa_application_id")
    private Long paApplicationId;

    @Column(name = "cross_reference_id")
    private Long crossReferenceId;

    @Column(name = "follow_to_join")
    private String followToJoin;

    @Column(name = "create_date")
    private java.sql.Date createDate;

    @Column(name = "total_applicant")
    private String totalApplicant;

    @Column(name = "issued")
    private String issued;

    @Column(name = "refused")
    private Long refused;

    @Column(name = "traveling")
    private Long traveling;

    @Column(name = "will_join_applicants")
    private Long willJoinApplicants;


    /*
        Many Applicants can be part of one case
     */
    @ManyToOne
    @JoinColumn(name = "case_id")
    @JsonIgnore
    private Case applicantCase;

    /**
     * Instantiates a new Applicant.
     */
    public Applicant()
    {
    }

    /**
     * Instantiates a new Applicant.
     *
     * @param id          the id
     * @param firstName   the first name
     * @param middleName  the middle name
     * @param lastName    the last name
     * @param dob         the dob
     * @param alienNumber the alien number
     */
    public Applicant(Long id, String firstName, String middleName, String lastName, Date dob, String alienNumber)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.middleName = middleName;
        this.alienNumber = alienNumber;
    }

    /**
     * Instantiates a new Applicant.
     *
     * @param firstName   the first name
     * @param middleName  the middle name
     * @param lastName    the last name
     * @param dob         the dob
     * @param alienNumber the alien number
     */
    public Applicant(String firstName, String middleName, String lastName, Date dob, String alienNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.middleName = middleName;
        this.alienNumber = alienNumber;
    }

    @Override
    public String toString()
    {
        return "Applicant{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", middleName='" + middleName + '\'' +
                ", birthPlaceCountryCode='" + birthPlaceCountryCode + '\'' +
                ", identFingerPrintId=" + identFingerPrintId +
                ", nationalityCode='" + nationalityCode + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", visaControlNumber='" + visaControlNumber + '\'' +
                ", alienNumber='" + alienNumber + '\'' +
                ", siteCode='" + siteCode + '\'' +
                ", paApplicationId=" + paApplicationId +
                ", crossReferenceId=" + crossReferenceId +
                ", followToJoin='" + followToJoin + '\'' +
                ", createDate=" + createDate +
                ", totalApplicant='" + totalApplicant + '\'' +
                ", issued='" + issued + '\'' +
                ", refused=" + refused +
                ", traveling=" + traveling +
                ", willJoinApplicants=" + willJoinApplicants +
                '}';
    }
}
