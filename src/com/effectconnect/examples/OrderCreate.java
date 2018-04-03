package com.effectconnect.examples;

import com.effectconnect.Abstracts.CallType;
import com.effectconnect.ApiCall;
import com.effectconnect.Response.ApiResponse;
import com.effectconnect.ApiSettings;
import com.effectconnect.CallType.OrderCall;
import com.effectconnect.Enum.FeeType;
import com.effectconnect.Enum.GenderType;
import com.effectconnect.Enum.OrderAddressType;
import com.effectconnect.Enum.ProductIdentifierType;
import com.effectconnect.Model.*;

import java.util.Date;

final public class OrderCreate {
    public ApiResponse call(ApiSettings settings) {

        OrderFee shippingFee = new OrderFee()
            .setType(FeeType.SHIPPING_TYPE)
            .setAmount(6.50)
        ;
        OrderAddress billingAddress = new OrderAddress(OrderAddressType.BILLING)
            .setSalutation(GenderType.MALE)
            .setFirstName("Stefan")
            .setLastName("Van den Heuvel")
            .setCompany("Koek & Peer")
            .setStreet("Tolhuisweg")
            .setHouseNumber(5)
            .setHouseNumberExtension("a")
            .setAddressNote("The office")
            .setZipCode("6071RG")
            .setCity("Swalmen")
            .setState("Limburg")
            .setCountry("NL")
            .setPhone("0123456789")
            .setEmail("test@effectconnect.com")
        ;
        OrderAddress shippingAddress = new OrderAddress(OrderAddressType.SHIPPING)
            .setSalutation(GenderType.MALE)
            .setFirstName("Stefan")
            .setLastName("Van den Heuvel")
            .setCompany("Koek & Peer")
            .setStreet("Tolhuisweg")
            .setHouseNumber(5)
            .setZipCode("6071RG")
            .setCity("Swalmen")
            .setState("Limburg")
            .setCountry("NL")
            .setEmail("test@effectconnect.com")
        ;
        ProductIdentifier skuIdentifier = new ProductIdentifier()
            .setType(ProductIdentifierType.SKU)
            .setValue("TEST-1234")
        ;
        ProductIdentifier eanIdentifier = new ProductIdentifier()
            .setType(ProductIdentifierType.EAN)
            .setValue("012345678912")
        ;
        OrderFee commission = new OrderFee()
            .setType(FeeType.COMMISSION_TYPE)
            .setAmount(0.50)
        ;
        OrderLine firstLine = new OrderLine()
            .setId("Test-123-1")
            .setQuantity(2)
            .setProductTitle("Test product 1")
            .setIndividualProductPrice(12.50)
            .addFee(commission)
            .addProductIdentifier(skuIdentifier)
            .addProductIdentifier(eanIdentifier)
        ;
        Order order = new Order()
            .setNumber("Test-123")
            .setCurrency("EUR")
            .setDate(new Date())
            .setBillingAddress(billingAddress)
            .setShippingAddress(shippingAddress)
            .addFee(shippingFee)
            .addLine(firstLine)
        ;
        CallType calltype = new OrderCall().create(order);
        ApiCall apiCall = new ApiCall(settings, calltype);

        return apiCall.call();
    }
}
