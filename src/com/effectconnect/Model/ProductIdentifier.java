package com.effectconnect.Model;

import com.effectconnect.Enum.ProductIdentifierType;
import com.effectconnect.Interface.ECModelInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

final public class ProductIdentifier implements ECModelInterface {

    private ProductIdentifierType type;
    private String value;

    public ProductIdentifier setType(ProductIdentifierType type) {
        this.type = type;

        return this;
    }

    public ProductIdentifier setValue(String value) {
        this.value = value;

        return this;
    }

    @Override
    public Element toXml(Document doc) {
        Element rootElement = doc.createElement("identifier");
        Element type = doc.createElement("type");
        Element amount = doc.createElement("value");

        type.setTextContent(this.type.toString());
        amount.setTextContent(this.value);

        rootElement.appendChild(type);
        rootElement.appendChild(amount);

        return rootElement;
    }
}
