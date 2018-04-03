package com.effectconnect.Transformer;

import com.effectconnect.Interface.ECModelInterface;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

final public class ModelToXmlTransformer {

    public static String transform(ECModelInterface ecModel) {
        StringWriter stringWriter = new StringWriter();
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.appendChild(ecModel.toXml(doc));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, new StreamResult(stringWriter));
        } catch (ParserConfigurationException|TransformerException pce) {
            System.out.println("Failed to build xml: "+pce.getMessage());
        }

        return stringWriter.toString();
    }
}
