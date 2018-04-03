package com.effectconnect.Response;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;

final public class ApiResponse {
    private Integer responseCode;
    private String rawResponse;
    private Request request;
    private Response response;
    private ErrorContainer errorContainer;

    public ApiResponse (Integer responseCode, String response) {
        this.responseCode = responseCode;
        this.rawResponse = response;
        this._parseResponse();
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public String getRawResponse() {
        return rawResponse;
    }

    private void _parseResponse() {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(new InputSource(new StringReader(this.rawResponse.replace("<?xml version=\"1.0\"?>", ""))));
            Document doc = parser.getDocument();
            Node root = doc.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node currentNode = nodes.item(i);
                if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    switch (currentNode.getNodeName()) {
                        case "Request":
                            this.request = new Request(currentNode);
                            break;
                        case "Response":
                            this.response = new Response(currentNode);
                            break;
                        case "ErrorContainer":
                            this.errorContainer = new ErrorContainer(currentNode);
                            break;
                    }
                }
            }
        } catch (IOException|SAXException e) {
            System.out.println(e.getMessage());
        }
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public ErrorContainer getErrorContainer() {
        return errorContainer;
    }
}
