package com.effectconnect.Response;

import com.effectconnect.Enum.ErrorCode;
import com.effectconnect.Enum.ErrorSeverity;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final public class EffectConnectError {
    private static final String SEVERITY_WARNING = "Warning";
    private static final String SEVERITY_ERROR = "Error";

    private ErrorSeverity severity;
    private ErrorCode code;
    private String message;

    EffectConnectError(Node error) {
        NodeList nodes = error.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node currentNode = nodes.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                switch (currentNode.getNodeName()) {
                    case "Severity":
                        switch (currentNode.getTextContent()) {
                            case SEVERITY_WARNING:
                                this.severity = ErrorSeverity.WARNING;
                                break;
                            case SEVERITY_ERROR:
                                this.severity = ErrorSeverity.ERROR;
                                break;
                        }
                        break;
                    case "Code":
                        for (ErrorCode e: ErrorCode.values()) {
                            if (e.toString().equals(currentNode.getTextContent())) {
                                this.code = e;
                            }
                        }
                        break;
                    case "Message":
                        this.message = currentNode.getTextContent();
                        break;
                }
            }
        }
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

    public ErrorCode getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
