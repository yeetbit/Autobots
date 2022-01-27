/*
 * Copyright (C) 2022 obi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dev.obit.tools.watchdog.model;

import java.io.Serializable;

/**
 *
 * @author obi
 */

public class PersonalInformation implements Serializable {
    
    /**
     * The Account object is a representation of the user data, 
     * In regards to privacy: Once the object is created the user can select to store it as a serialized object or a plain text file.
     * The user will be notified with the 
     * 
     * personal information
     */
    private final String name;
    private final String lastName;
    private final String emailAddress;
    private final String street;
    private final String houseNumber;
    private final String suite;
    private final String zipCode;
    private final String country;

    /**
     * credit card data
     */
    private final String cardHolder;
    private final String cardNumber;
    private final String expirationDate;
    private final String cvc;

    /**
     * 
     * @param name          first name field of the user
     * @param lastName      last name field of the user
     * @param emailAddress  email address of the user
     * @param street        street name for shipping & billing
     * @param houseNumber   house/building number for shipping & billing
     * @param suite         suite/apartment number for shipping & billing
     * @param zipCode       zipCode for shipping & billing
     * @param country       country for shipping & billing
     * @param cardHolder    name linked credit card account
     * @param cardNumber    credit card account number
     * @param date          credit card expiration date 
     * @param cvc           card verification code
     */
    public PersonalInformation(String name, String lastName, String emailAddress, String street, String houseNumber, String suite, String zipCode, String country, String cardHolder, String cardNumber, String date, String cvc) {
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.street = street;
        this.houseNumber = houseNumber;
        this.suite = suite;
        this.zipCode = zipCode;
        this.country = country;
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.expirationDate = date;
        this.cvc = cvc;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getApartment() {
        return suite;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvc() {
        return cvc;
    }
    
    
    
    
    
    
    
}
