package com.effectconnect.Response;

import com.effectconnect.Helper.ECParser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.text.ParseException;
import java.util.Date;

final public class Request {
    private String requestType;
    private String requestAction;
    private String requestVersion;
    private String identifier;
    private Date processedAt;

    Request(Node request) {
        NodeList nodes = request.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node currentNode = nodes.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                switch (currentNode.getNodeName())
                {
                    case "RequestType":
                        this.requestType = currentNode.getTextContent();
                        break;
                    case "RequestAction":
                        this.requestAction = currentNode.getTextContent();
                        break;
                    case "RequestVersion":
                        this.requestVersion = currentNode.getTextContent();
                        break;
                    case "RequestIdentifier":
                        this.identifier = currentNode.getTextContent();
                        break;
                    case "ProcessedAt":
                        try {
                            this.processedAt = ECParser.parseDate(currentNode.getTextContent());
                        } catch (ParseException e) {
                            this.processedAt = null;
                        }
                        break;
                }
            }
        }
    }

    public String getRequestType() {
        return requestType;
    }

    public String getRequestAction() {
        return requestAction;
    }

    public String getRequestVersion() {
        return requestVersion;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Date getProcessedAt() {
        return processedAt;
    }
}
