package com.openfinanceorganisation.businessrule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationDTO implements Serializable {

    @JsonProperty("AddressLine1")
    private String addressLineOne;

    @JsonProperty("AddressLine2")
    private String addressLineTwo;

    @JsonProperty("City")
    private String city;

    @JsonProperty("CompanyRegister")
    private String companyRegister;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryOfRegistration")
    private String countryOfRegistration;

    @JsonProperty("CreatedOn")
    private LocalDate createdOn;

    @JsonProperty("LegalEntityName")
    private String legalEntityName;

    @JsonProperty("OrganisationId")
    private String organisationId;

    @JsonProperty("OrganisationName")
    private String organisationName;

    @JsonProperty("ParentOrganisationReference")
    private String parentOrganisationReference;

    @JsonProperty("Postcode")
    private String postCode;

    @JsonProperty("RegisteredName")
    private String registeredName;

    @JsonProperty("RegistrationId")
    private String registrationId;

    @JsonProperty("RegistrationNumber")
    private String registrationNumber;

    @JsonProperty("RequiresParticipantTermsAndConditionsSigning")
    private Boolean requiresParticipantsTermsAndConditionsSigning;

    @JsonProperty("Size")
    private String size;

}
