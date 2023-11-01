package com.openfinanceorganisation.interfaceadapter.repository;

import com.openfinanceorganisation.domain.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation, String> {

    @Query(value = "SELECT * FROM organisation WHERE legal_entity_name = :legalEntityName", nativeQuery = true)
    Optional<Organisation> findByLegalEntityName(String legalEntityName);
}
