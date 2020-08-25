package com.renanzulian.xmlproject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainSystem {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("src/sales.xml");

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
