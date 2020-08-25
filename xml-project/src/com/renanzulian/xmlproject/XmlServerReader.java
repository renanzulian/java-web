package com.renanzulian.xmlproject;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.InputStream;

public class XmlServerReader {
    public static void main(String[] args) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();

        MyXmlReader xmlReader = new MyXmlReader();
        reader.setContentHandler(xmlReader);

        InputStream inputStream = new FileInputStream("src/sales.xml");
        InputSource inputSource = new InputSource(inputStream);

        reader.parse(inputSource);

        System.out.println(xmlReader.getProducts());
    }
}
