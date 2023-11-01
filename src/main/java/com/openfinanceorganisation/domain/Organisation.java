package com.openfinanceorganisation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organisation")
public class Organisation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "organisation_id")
    private String organisationId;

    @Column(name = "company_register")
    private String companyRegister;

    @Column(name = "address_line1")
    private String addressLineOne;

    @Column(name = "address_line2")
    private String addressLineTwo;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "registered_name")
    private String registeredName;

    @Column(name = "postcode")
    private String postCode;

    @Column(name = "registration_id")
    private String registrationId;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "legal_entity_name")
    private String legalEntityName;

    @Column(name = "country_of_registration")
    private String countryOfRegistration;

    @Column(name = "organisation_name")
    private String organisationName;

    @Column(name = "parent_organisation_reference")
    private String parentOrganisationReference;

    @Column(name = "requires_participants_terms_and_conditions_signing")
    private Boolean requiresParticipantsTermsAndConditionsSigning;

    @Column(name = "status")
    private String status;

    @Column(name = "size")
    private String size;

    @Column(name = "tags")
    private String tags;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "created_on")
    private LocalDate createdOn;

}
