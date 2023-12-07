package com.example.Test.Model;

import jakarta.persistence.*;

/**
 * @author Titus Murithi Bundi
 */

/**
 * Represents a phone number entity in the application.
 * Annotated with JPA annotations to enable mapping to a database table.
 */
@Entity
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String state;
    private String countryCode;
    private String number;

    /**
     * Constructor for creating a PhoneNumber with specified properties.
     *
     * @param id          The unique identifier for the phone number.
     * @param country     The country associated with the phone number.
     * @param state       The state associated with the phone number.
     * @param countryCode The country code associated with the phone number.
     * @param number      The actual phone number.
     */
    public PhoneNumber(Long id, String country, String state, String countryCode, String number) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.countryCode = countryCode;
        this.number = number;
    }

    /**
     * Default constructor required by JPA.
     */
    public PhoneNumber() {

    }

    /**
     * Getter for retrieving the unique identifier of the phone number.
     *
     * @return The unique identifier.
     */
    public Long getId() {
        return id;
    }


    /**
     * Setter for setting the unique identifier of the phone number.
     *
     * @param id The unique identifier to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for providing a user-friendly representation of the phone number.
     *
     * @return A user-friendly string containing country and number information.
     */
    public String getUserFriendlyInfo() {
        return String.format("Country: %s, Number: %s", this.country, this.number);
    }

    /**
     * Getter for retrieving the country associated with the phone number.
     *
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for setting the country associated with the phone number.
     *
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Getter for retrieving the state associated with the phone number.
     *
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for setting the state associated with the phone number.
     *
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for retrieving the country code associated with the phone number.
     *
     * @return The country code.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Setter for setting the country code associated with the phone number.
     *
     * @param countryCode The country code to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Getter for retrieving the actual phone number.
     *
     * @return The phone number.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter for setting the actual phone number.
     *
     * @param number The phone number to set.
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
