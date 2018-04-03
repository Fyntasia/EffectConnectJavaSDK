package com.effectconnect.Model;

import com.effectconnect.Enum.FeeType;
import com.effectconnect.Helper.ECFormatter;
import com.effectconnect.Interface.ECModelInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

final public class OrderFee implements ECModelInterface {

    private FeeType type;
    private Double amount;

    public OrderFee setType(FeeType type) {
        this.type = type;

        return this;
    }

    public OrderFee setAmount(Double amount) {
        this.amount = amount;

        return this;
    }

    @Override
    public Element toXml(Document doc) {
        Element rootElement = doc.createElement("fee");
        Element type = doc.createElement("type");
        Element amount = doc.createElement("amount");
        type.setTextContent(this.type.toString());
        amount.setTextContent(ECFormatter.formatPrice(this.amount));
        rootElement.appendChild(type);
        rootElement.appendChild(amount);

        return rootElement;
    }
}
