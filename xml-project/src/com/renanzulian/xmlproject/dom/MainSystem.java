package com.renanzulian.xmlproject.dom;

import com.renanzulian.xmlproject.models.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainSystem {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/sales.xml");

        Element sale = document.getDocumentElement();
        String currency = sale.getAttribute("currency");

        System.out.println("Sales PARSER XML\nCurrency: " + currency + "\n");

        NodeList productsName = document.getElementsByTagName("Name");
        NodeList prices = document.getElementsByTagName("Price");

        for (int i = 0; i < productsName.getLength(); i++) {
            Element name = (Element) productsName.item(i);
            Element price = (Element) prices.item(i);
            Product product = new Product(name.getTextContent(), Double.parseDouble(price.getTextContent()));
            System.out.println(product);
        }

    }
}
