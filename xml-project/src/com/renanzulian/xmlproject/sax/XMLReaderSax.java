package com.renanzulian.xmlproject.sax;

import com.renanzulian.xmlproject.handlers.ProductHandlerXML;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.InputStream;

public class XMLReaderSax {
    public static void main(String[] args) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();

        ProductHandlerXML xmlReader = new ProductHandlerXML();
        reader.setContentHandler(xmlReader);

        InputStream inputStream = new FileInputStream("src/sales.xml");
        InputSource inputSource = new InputSource(inputStream);

        reader.parse(inputSource);

        System.out.println(xmlReader.getProducts());
    }
}
