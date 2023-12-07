package com.example.Test;

import com.example.Test.Model.PhoneNumber;
import com.example.Test.Repository.PhoneNumberRepository;
import com.example.Test.Service.PhoneNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Titus Murithi Bundi
 */
public class PhoneNumberServiceTest {

    @Mock
    private PhoneNumberRepository phoneNumberRepository;

    @InjectMocks
    private PhoneNumberService phoneNumberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPhoneNumbers() {
        // Arrange
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        when(phoneNumberRepository.findAll()).thenReturn(phoneNumbers);

        // Act
        List<PhoneNumber> result = phoneNumberService.getAllPhoneNumbers();

        // Assert
        assertEquals(phoneNumbers, result);
        verify(phoneNumberRepository, times(1)).findAll();
    }

    // Similar tests for other methods...

    @Test
    void createPhoneNumber_ValidPhoneNumber_ShouldSave() {
        // Arrange
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountry("Cameroon");
        phoneNumber.setNumber("(237)12345678");

        when(phoneNumberRepository.save(any(PhoneNumber.class))).thenReturn(phoneNumber);

        // Act
        PhoneNumber result = phoneNumberService.createPhoneNumber(phoneNumber);

        // Assert
        assertNotNull(result);
        verify(phoneNumberRepository, times(1)).save(any(PhoneNumber.class));
    }

    @Test
    void createPhoneNumber_InvalidPhoneNumber_ShouldThrowException() {
        // Arrange
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCountry("Cameroon");
        phoneNumber.setNumber("InvalidNumber");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> phoneNumberService.createPhoneNumber(phoneNumber));
        verify(phoneNumberRepository, never()).save(any(PhoneNumber.class));
    }
}
