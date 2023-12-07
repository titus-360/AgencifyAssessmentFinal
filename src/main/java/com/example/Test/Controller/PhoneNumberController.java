package com.example.Test.Controller;


import com.example.Test.Model.PhoneNumber;
import com.example.Test.Service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Titus Murithi Bundi
 */

/**
 * Controller class for handling phone number-related operations.
 */

@RestController
@RequestMapping("/api/phone-numbers")
@CrossOrigin(origins = "http://localhost:4200")
public class PhoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    /**
     * Constructor for PhoneNumberController, injecting the PhoneNumberService dependency.
     *
     * @param phoneNumberService The service responsible for business logic related to phone numbers.
     */

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    /**
     * Handles HTTP GET requests to retrieve all phone numbers.
     *
     * @param page The page number for paginated results (default is 0).
     * @param size The number of items per page (default is 10).
     * @return A Page of PhoneNumber objects containing the requested phone numbers.
     */

    @GetMapping
    public Page<PhoneNumber> getAllPhoneNumbers(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return phoneNumberService.getAllPhoneNumbers(PageRequest.of(page, size));
    }

    /**
     * Handles HTTP GET requests to retrieve filtered phone numbers based on country or state.
     * @param country (Optional) The country to filter by.
     * @param state (Optional) The state to filter by.
     * @param page The page number for paginated results (default is 0).
     * @param size The number of items per page (default is 10).
     * @return A Page of PhoneNumber objects containing the filtered phone numbers.
     */

    @GetMapping("/filter")
    public Page<PhoneNumber> getFilteredPhoneNumbers(@RequestParam(required = false) String country,
                                                     @RequestParam(required = false) String state,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        return phoneNumberService.getFilteredPhoneNumbers(country, state, PageRequest.of(page, size));
    }

    /**
     * Handles HTTP POST requests to create a new phone number.
     * @param phoneNumber The PhoneNumber object representing the new phone number.
     * @return ResponseEntity with the created PhoneNumber or a JSON error response.
     */

    @PostMapping
    public ResponseEntity<Object> createPhoneNumber(@RequestBody PhoneNumber phoneNumber) {
        try {
            PhoneNumber createdPhoneNumber = phoneNumberService.createPhoneNumber(phoneNumber);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPhoneNumber);
        } catch (IllegalArgumentException e) {
            // Catch the exception and return a JSON response with an error message
            String errorMessage = e.getMessage();
            // Include user-entered information in the error response
            String userEnteredInfo = phoneNumber != null ? phoneNumber.getUserFriendlyInfo() : "No user information provided";
            String errorResponse = String.format("{\"error\": \"%s\", \"user_info\": \"%s\"}", errorMessage, userEnteredInfo);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
