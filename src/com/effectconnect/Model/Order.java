package com.effectconnect.Model;

import com.effectconnect.Helper.ECFormatter;
import com.effectconnect.Interface.ECModelInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

final public class Order implements ECModelInterface {
    private String number;
    private String currency;
    private Date date;
    private ArrayList<OrderFee> fees = new ArrayList<>();
    private OrderAddress billingAddress;
    private OrderAddress shippingAddress;
    private ArrayList<OrderLine> lines = new ArrayList<>();

    public Order setNumber(String number) {
        this.number = number;

        return this;
    }

    public Order setCurrency(String currency) {
        this.currency = currency;

        return this;
    }

    public Order setDate(Date date) {
        this.date = date;

        return this;
    }

    public Order addFee(OrderFee fee) {
        this.fees.add(fee);

        return this;
    }

    public Order setBillingAddress(OrderAddress billingAddress) {
        this.billingAddress = billingAddress;

        return this;
    }

    public Order setShippingAddress(OrderAddress shippingAddress) {
        this.shippingAddress = shippingAddress;

        return this;
    }

    public Order addLine(OrderLine line) {
        this.lines.add(line);

        return this;
    }

    @Override
    public Element toXml(Document doc) {
        Element rootElement = doc.createElement("order");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ") {
            public StringBuffer format(Date date, StringBuffer toAppendTo, java.text.FieldPosition pos) {
                StringBuffer toFix = super.format(date, toAppendTo, pos);
                return toFix.insert(toFix.length()-2, ':');
            };
        };
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Amsterdam"));
        Element number = doc.createElement("number");
        Element currency = doc.createElement("currency");
        Element date = doc.createElement("date");
        Element fees = doc.createElement("fees");
        Element orderLines = doc.createElement("lines");
        number.setTextContent(this.number);
        currency.setTextContent(this.currency);
        date.setTextContent(ECFormatter.formatDate(this.date));
        for (OrderLine line: this.lines) {
            orderLines.appendChild(line.toXml(doc));
        }
        for (OrderFee fee: this.fees) {
            fees.appendChild(fee.toXml(doc));
        }

        rootElement.appendChild(number);
        rootElement.appendChild(currency);
        rootElement.appendChild(date);
        rootElement.appendChild(this.billingAddress.toXml(doc));
        rootElement.appendChild(this.shippingAddress.toXml(doc));
        rootElement.appendChild(orderLines);
        rootElement.appendChild(fees);

        return rootElement;
    }
}
