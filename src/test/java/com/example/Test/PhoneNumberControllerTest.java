package com.example.Test;

import com.example.Test.Controller.PhoneNumberController;
import com.example.Test.Model.PhoneNumber;
import com.example.Test.Service.PhoneNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Titus Murithi Bundi
 */

class PhoneNumberControllerTest {

    @Mock
    private PhoneNumberService phoneNumberService;

    @InjectMocks
    private PhoneNumberController phoneNumberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPhoneNumbers() {
        // Arrange
        Page<PhoneNumber> phoneNumbers = new PageImpl<>(Collections.singletonList(new PhoneNumber()));
        when(phoneNumberService.getAllPhoneNumbers(any(PageRequest.class))).thenReturn(phoneNumbers);

        // Act
        Page<PhoneNumber> result = phoneNumberController.getAllPhoneNumbers(0, 10);

        // Assert
        assertEquals(phoneNumbers, result);
        verify(phoneNumberService, times(1)).getAllPhoneNumbers(any(PageRequest.class));
    }

    @Test
    void getFilteredPhoneNumbers() {
        // Arrange
        Page<PhoneNumber> filteredPhoneNumbers = new PageImpl<>(Collections.singletonList(new PhoneNumber()));
        when(phoneNumberService.getFilteredPhoneNumbers(anyString(), anyString(), any(PageRequest.class)))
                .thenReturn(filteredPhoneNumbers);

        // Act
        Page<PhoneNumber> result = phoneNumberController.getFilteredPhoneNumbers("Cameroon", "Active", 0, 10);

        // Assert
        assertEquals(filteredPhoneNumbers, result);
        verify(phoneNumberService, times(1)).getFilteredPhoneNumbers(anyString(), anyString(), any(PageRequest.class));
    }

    @Test
    void createPhoneNumber_ValidPhoneNumber_ShouldReturnCreated() {
        // Arrange
        PhoneNumber phoneNumber = new PhoneNumber();
        when(phoneNumberService.createPhoneNumber(any(PhoneNumber.class))).thenReturn(phoneNumber);

        // Act
        ResponseEntity<Object> response = phoneNumberController.createPhoneNumber(phoneNumber);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(phoneNumber, response.getBody());
        verify(phoneNumberService, times(1)).createPhoneNumber(any(PhoneNumber.class));
    }

    @Test
    void createPhoneNumber_InvalidPhoneNumber_ShouldReturnBadRequest() {
        // Arrange
        PhoneNumber phoneNumber = new PhoneNumber();
        when(phoneNumberService.createPhoneNumber(any(PhoneNumber.class))).thenThrow(new IllegalArgumentException("Invalid phone number"));

        // Act
        ResponseEntity<Object> response = phoneNumberController.createPhoneNumber(phoneNumber);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("{\"error\": \"Invalid phone number\", \"user_info\": \"No user information provided\"}", response.getBody());
        verify(phoneNumberService, times(1)).createPhoneNumber(any(PhoneNumber.class));
    }

    // Add more tests as needed...
}
