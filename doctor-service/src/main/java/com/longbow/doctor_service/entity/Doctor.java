package com.longbow.doctor_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DOCTOR")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCTOR_ID")
    private Integer id;

    @Column(name = "DOCTOR_FIRST_NAME", length = 64)
    private String firstName;

    @Column(name = "DOCTOR_LAST_NAME", length = 64)
    private String lastName;

    @Column(name = "GENDER", length = 16)
    private String gender;

    @Column(name = "COUNTRY_CODE")
    private Integer countryCode;

    @Column(name = "MOBILE", length = 16)
    private String mobile;

    @Column(name = "EMAIL", length = 128, unique = true)
    private String email;

    @Column(name = "SPECIALIZATION", length = 255)
    private String specialization;

    @Column(name = "QUALIFICATION", length = 255)
    private String qualification;

    @Column(name = "MOBILE_NUMBER_VERIFIED")
    private Boolean mobileNumberVerified;

    @Column(name = "EMAIL_VERIFIED")
    private Boolean emailVerified=false;

    @Column(name = "STREET", columnDefinition = "LONGTEXT")
    private String street;

    @Column(name = "AREA", length = 255)
    private String area;

    @Column(name = "CITY", length = 255)
    private String city;

    @Column(name = "STATE", length = 255)
    private String state;

    @Column(name = "ZIPCODE", length = 255)
    private String zipcode;

    @Column(name = "COUNTRY", length = 264)
    private String country;

    @Column(name = "PRACTICE_NAME", length = 1024)
    private String practiceName;

    @Column(name = "HOSPITAL_NAME", length = 255)
    private String hospitalName;

    @Column(name = "HOSPITAL_ADDRESS", length = 512)
    private String hospitalAddress;

    @Column(name = "CLINIC_ZIPCODE", length = 50)
    private String clinicZipcode;

    @Column(name = "DOCTOR_BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date doctorBirthday;

    @Column(name = "DOCTOR_MARRIAGE_ANNIVERSARY")
    @Temporal(TemporalType.DATE)
    private Date doctorMarriageAnniversary;

    @Column(name = "LIST_OF_SERVICES_OFFERED", columnDefinition = "TINYTEXT")
    private String listOfServicesOffered;

    @Column(name = "GBP_AVAILABLE")
    private Boolean gbpAvailable;

    @Column(name = "WORKING_HOURS", length = 128)
    private String workingHours;

    @Column(name = "DESIGNATION", length = 128)
    private String designation;

    @Column(name = "PROFESSIONAL_EXPERIENCE_YEARS")
    private Integer professionalExperienceYears;

    @Column(name = "INTRODUCTION", columnDefinition = "TINYTEXT")
    private String introduction;

    @Column(name = "PUBLICATIONS_ACHIEVEMENTS", columnDefinition = "TINYTEXT")
    private String publicationsAchievements;

    @Column(name = "MEMBERSHIPS", columnDefinition = "TINYTEXT")
    private String memberships;

    @Column(name = "DOCTOR_PHOTO", length = 255)
    private String doctorPhoto;

    @Column(name = "DEPARTMENTS", columnDefinition = "TINYTEXT")
    private String departments;

    @Column(name = "PREFERRED_WORLD_DAYS", columnDefinition = "TINYTEXT")
    private String preferredWorldDays;

    @Column(name = "LANGUAGE_PREFERENCE", columnDefinition = "TINYTEXT")
    private String languagePreference;

    @Column(name = "LANGUAGE_TRIGGERS", columnDefinition = "TINYTEXT")
    private String languageTriggers;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "BILLING_ENTITY_NAME", length = 255)
    private String billingEntityName;

    @Column(name = "ALTERNATE_CONTACT_NAME", length = 64)
    private String alternateContactName;

    @Column(name = "ALTERNATE_CONTACT_NUMBER", length = 16)
    private String alternateContactNumber;

    @Column(name = "MAIL_VERIFIFCATION_TOKEN", length = 512)
    private String mailVerificationToken;

    @Column(name = "GST_NO", length = 32)
    private String gstNo;

    @Column(name = "OTP", length = 10)
    private String otp;

    @Column(name = "OTP_GENERATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date otpGeneratedTime;

    @Column(name = "PASSWORD", columnDefinition = "TINYTEXT")
    private String password;

    @Column(name = "USERNAME", columnDefinition = "TINYTEXT")
    private String username;
}
