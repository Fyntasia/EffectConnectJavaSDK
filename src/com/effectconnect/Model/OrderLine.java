package com.effectconnect.Model;

import com.effectconnect.Helper.ECFormatter;
import com.effectconnect.Interface.ECModelInterface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;

final public class OrderLine implements ECModelInterface {

    private String id;
    private ArrayList<ProductIdentifier> productIdentifiers = new ArrayList<>();
    private String productTitle;
    private Integer quantity;
    private Double individualProductPrice;
    private ArrayList<OrderFee> fees = new ArrayList<>();

    public OrderLine setId(String id) {
        this.id = id;

        return this;
    }

    public OrderLine addProductIdentifier(ProductIdentifier productIdentifier) {
        this.productIdentifiers.add(productIdentifier);

        return this;
    }

    public OrderLine setProductTitle(String productTitle) {
        this.productTitle = productTitle;

        return this;
    }

    public OrderLine setQuantity(Integer quantity) {
        this.quantity = quantity;

        return this;
    }

    public OrderLine setIndividualProductPrice(Double individualProductPrice) {
        this.individualProductPrice = individualProductPrice;

        return this;
    }

    public OrderLine addFee(OrderFee fee) {
        this.fees.add(fee);

        return this;
    }

    @Override
    public Element toXml(Document doc) {
        Element rootElement = doc.createElement("line");
        Element id = doc.createElement("id");
        Element productTitle = doc.createElement("productTitle");
        Element quantity = doc.createElement("quantity");
        Element individualProductPrice = doc.createElement("individualProductPrice");
        Element productIdentifiers = doc.createElement("productIdentifiers");
        Element fees = doc.createElement("fees");
        id.setTextContent(this.id);
        productTitle.setTextContent(this.productTitle);
        quantity.setTextContent(this.quantity.toString());
        individualProductPrice.setTextContent(ECFormatter.formatPrice(this.individualProductPrice));
        for (ProductIdentifier identifier: this.productIdentifiers) {
            productIdentifiers.appendChild(identifier.toXml(doc));
        }
        for (OrderFee fee: this.fees) { fees.appendChild(fee.toXml(doc)); }
        rootElement.appendChild(id);
        rootElement.appendChild(productIdentifiers);
        rootElement.appendChild(productTitle);
        rootElement.appendChild(quantity);
        rootElement.appendChild(individualProductPrice);
        rootElement.appendChild(fees);

        return rootElement;
    }
}
