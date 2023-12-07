package com.example.Test.Repository;

import com.example.Test.Model.PhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Titus Murithi Bundi
 */


/**
 * Repository interface for PhoneNumber entities, extending JpaRepository.
 * Provides methods for querying phone numbers by country and state.
 */
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    // Find phone numbers by country and state
    List<PhoneNumber> findByCountryAndState(String country, String state);

    // Find all phone numbers with pagination support
    Page<PhoneNumber> findAll(Pageable pageable);

    // Find phone numbers by country and state with pagination support
    Page<PhoneNumber> findByCountryAndState(String country, String state, Pageable pageable);
}
