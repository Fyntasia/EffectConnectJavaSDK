package com.effectconnect.Response;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;

final public class ErrorContainer {
    private ArrayList<EffectConnectError> errors = new ArrayList<>();

    ErrorContainer(Node request) {
        NodeList nodes = request.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node currentNode = nodes.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                this.errors.add(new EffectConnectError(currentNode));
            }
        }
    }

    public ArrayList<EffectConnectError> getErrors() {
        return errors;
    }
}
