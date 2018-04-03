package com.effectconnect.Model;

import com.effectconnect.Enum.GenderType;
import com.effectconnect.Enum.OrderAddressType;
import com.effectconnect.Interface.ECModelInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

final public class OrderAddress implements ECModelInterface {

    private OrderAddressType type;
    private GenderType salutation;
    private String firstName;
    private String lastName;
    private String company;
    private String street;
    private Integer houseNumber;
    private String houseNumberExtension;
    private String addressNote;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;

    public OrderAddress(OrderAddressType type) {
        this.type = type;
    }

    public OrderAddress setSalutation(GenderType salutation) {
        this.salutation = salutation;

        return this;
    }

    public OrderAddress setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public OrderAddress setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public OrderAddress setCompany(String company) {
        this.company = company;

        return this;
    }

    public OrderAddress setStreet(String street) {
        this.street = street;

        return this;
    }

    public OrderAddress setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;

        return this;
    }

    public OrderAddress setHouseNumberExtension(String houseNumberExtension) {
        this.houseNumberExtension = houseNumberExtension;

        return this;
    }

    public OrderAddress setAddressNote(String addressNote) {
        this.addressNote = addressNote;

        return this;
    }

    public OrderAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;

        return this;
    }

    public OrderAddress setCity(String city) {
        this.city = city;

        return this;
    }

    public OrderAddress setState(String state) {
        this.state = state;

        return this;
    }

    public OrderAddress setCountry(String country) {
        this.country = country;

        return this;
    }

    public OrderAddress setPhone(String phone) {
        this.phone = phone;

        return this;
    }

    public OrderAddress setEmail(String email) {
        this.email = email;

        return this;
    }

    @Override
    public Element toXml(Document doc) {
        Element rootElement = doc.createElement(this.type+"Address");
        Element salutation = doc.createElement("salutation");
        salutation.setTextContent(this.salutation.toString());
        rootElement.appendChild(salutation);
        Element firstName = doc.createElement("firstName");
        Element lastName = doc.createElement("lastName");
        Element company = doc.createElement("company");
        Element street = doc.createElement("street");
        Element houseNumber = doc.createElement("houseNumber");
        Element zipCode = doc.createElement("zipCode");
        Element city = doc.createElement("city");
        Element country = doc.createElement("country");
        Element phone = doc.createElement("phone");
        Element email = doc.createElement("email");

        firstName.setTextContent(this.firstName);
        lastName.setTextContent(this.lastName);
        company.setTextContent(this.company);
        street.setTextContent(this.street);
        houseNumber.setTextContent(this.houseNumber.toString());
        zipCode.setTextContent(this.zipCode);
        city.setTextContent(this.city);
        country.setTextContent(this.country);
        phone.setTextContent(this.phone);
        email.setTextContent(this.email);

        rootElement.appendChild(firstName);
        rootElement.appendChild(lastName);
        rootElement.appendChild(company);
        rootElement.appendChild(street);
        rootElement.appendChild(houseNumber);
        rootElement.appendChild(zipCode);
        rootElement.appendChild(city);
        rootElement.appendChild(country);
        rootElement.appendChild(phone);
        rootElement.appendChild(email);

        if (this.houseNumberExtension != null) {
            Element houseNumberExtension = doc.createElement("houseNumberExtension");
            houseNumberExtension.setTextContent(this.houseNumberExtension);
            rootElement.appendChild(houseNumberExtension);
        }
        if (this.addressNote != null) {
            Element addressNote = doc.createElement("addressNote");
            addressNote.setTextContent(this.addressNote);
            rootElement.appendChild(addressNote);
        }
        if (this.state != null) {
            Element state = doc.createElement("state");
            state.setTextContent(this.state);
            rootElement.appendChild(state);
        }

        return rootElement;
    }
}
