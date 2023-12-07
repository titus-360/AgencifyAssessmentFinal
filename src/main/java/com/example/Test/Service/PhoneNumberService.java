package com.example.Test.Service;

import com.example.Test.Model.PhoneNumber;
import com.example.Test.Repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Titus Murithi Bundi
 */

/**
 * Service class for managing phone number operations.
 */
@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    // Get all phone numbers
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    // Get filtered phone numbers by country and state
    public List<PhoneNumber> getFilteredPhoneNumbers(String country, String state) {
        return phoneNumberRepository.findByCountryAndState(country, state);
    }

    // Get all phone numbers with pagination support
    public Page<PhoneNumber> getAllPhoneNumbers(Pageable pageable) {
        return phoneNumberRepository.findAll(pageable);
    }

    // Get filtered phone numbers by country and state with pagination support
    public Page<PhoneNumber> getFilteredPhoneNumbers(String country, String state, Pageable pageable) {
        return phoneNumberRepository.findByCountryAndState(country, state, pageable);
    }

    // Create a new phone number
    public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber)) {
            // Handle invalid phone number (e.g., throw an exception, return an error response)
            throw new IllegalArgumentException("Invalid phone number");
        }

        return phoneNumberRepository.save(phoneNumber);
    }

    // Validate phone number format using regular expressions
    private boolean isValidPhoneNumber(PhoneNumber phoneNumber) {
        switch (phoneNumber.getCountry()) {
            case "Cameroon":
                return phoneNumber.getNumber().matches("\\(237\\)\\ ?[2368]\\d{7,8}$");
            case "Ethiopia":
                return phoneNumber.getNumber().matches("\\(251\\)\\ ?[1-59]\\d{8}$");
            case "Morocco":
                return phoneNumber.getNumber().matches("\\(212\\)\\ ?[5-9]\\d{8}$");
            case "Mozambique":
                return phoneNumber.getNumber().matches("\\(258\\)\\ ?[28]\\d{7,8}$");
            case "Uganda":
                return phoneNumber.getNumber().matches("\\(256\\)\\ ?\\d{9}$");
            default:
                // Handle unknown country (e.g., throw an exception, return an error response)
                throw new IllegalArgumentException("Invalid country");
        }
    }
}
