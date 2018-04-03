package com.effectconnect.Response;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.effectconnect.Enum.ResponseResult;

final public class Response {

    private static final String RESULT_SUCCESS = "Success";
    private static final String RESULT_WARNING = "Warning";
    private static final String RESULT_ERROR = "Error";
    private ResponseResult result;
    private ResponseContainer container;

    Response(Node response) {
        NodeList nodes = response.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node currentNode = nodes.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                switch (currentNode.getNodeName()) {
                    case "Result":
                        switch (currentNode.getTextContent()) {
                            case RESULT_SUCCESS:
                                this.result = ResponseResult.SUCCESS;
                                break;
                            case RESULT_WARNING:
                                this.result = ResponseResult.WARNING;
                                break;
                            case RESULT_ERROR:
                                this.result = ResponseResult.ERROR;
                                break;
                        }
                        break;
                    default:
                        this.container = new ResponseContainer(currentNode);
                        break;
                }
            }
        }
    }

    public ResponseResult getResult() {
        return result;
    }

    public ResponseContainer getContainer() {
        return container;
    }
}
