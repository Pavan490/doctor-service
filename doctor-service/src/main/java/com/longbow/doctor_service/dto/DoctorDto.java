package com.longbow.doctor_service.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Integer id;
    @NotBlank(message = "First name is required")
    @Size(max = 64, message = "First name must not exceed 64 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 64, message = "Last name must not exceed 64 characters")
    private String lastName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Country code is required")
    @Min(value = 1, message = "Invalid country code")
    private Integer countryCode;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobile;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @NotBlank(message = "Qualification is required")
    private String qualification;

    private Boolean mobileNumberVerified;
    private Boolean emailVerified;
    private String street;
    private String area;
    private String city;
    private String state;

    @Pattern(regexp = "^[0-9]{5,10}$", message = "Invalid zipcode")
    private String zipcode;

    private String country;
    private String practiceName;
    private String hospitalName;
    private String hospitalAddress;

    @Pattern(regexp = "^[0-9]{5,10}$", message = "Invalid clinic zipcode")
    private String clinicZipcode;

    @Past(message = "Birthday must be a past date")
    private Date doctorBirthday;

    @Past(message = "Marriage anniversary must be a past date")
    private Date doctorMarriageAnniversary;

    private String listOfServicesOffered;
    private Boolean gbpAvailable;
    private String workingHours;
    private String designation;

    @Min(value = 0, message = "Experience cannot be negative")
    private Integer professionalExperienceYears;

    private String introduction;
    private String publicationsAchievements;
    private String memberships;
    private String doctorPhoto;
    private String departments;
    private String preferredWorldDays;
    private String languagePreference;
    private String languageTriggers;

    private Boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private String billingEntityName;
    private String alternateContactName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Alternate contact must be 10 digits")
    private String alternateContactNumber;

    private String gstNo;

    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    private String username;

    // ✅ ADD THIS FIELD
    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    private String password;
}
