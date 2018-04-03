package com.effectconnect.Response;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final public class ResponseContainer {

    private String processId = "";

    ResponseContainer(Node responseContainer) {
        NodeList nodes = responseContainer.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node currentNode = nodes.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                switch (currentNode.getNodeName()) {
                    case "ProcessID":
                        this.processId = currentNode.getTextContent();
                        break;
                }
            }
        }
    }
    public Boolean hasProcessId() {
        return !this.processId.isEmpty();
    }

    public String getProcessId() {
        return this.processId;
    }
}
