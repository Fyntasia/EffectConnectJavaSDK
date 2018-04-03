package com.effectconnect.CallType;

import com.effectconnect.Abstracts.CallType;
import com.effectconnect.Model.Order;
import com.effectconnect.Transformer.ModelToXmlTransformer;

final public class OrderCall extends CallType {

    @Override
    public String getUri() {
        return "/orders";
    }

    @Override
    public String getVersion() {
        return "2.0";
    }

    public OrderCall create(Order order) {
        this.method  = "POST";
        this.payload = ModelToXmlTransformer.transform(order);

        return this;
    }

    public OrderCall read() {
        this.method = "GET";

        return this;
    }

    public OrderCall update() {
        this.method = "PUT";

        return this;
    }
}
