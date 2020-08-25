package com.renanzulian.xmlproject;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyXmlReader extends DefaultHandler {

    private List<Product> products = new ArrayList<>();
    private Product currentProduct;
    private StringBuilder content;

    public List<Product> getProducts() {
        return products;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public StringBuilder getContent() {
        return content;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("Product")) {
            this.currentProduct = new Product();
        }
        this.content = new StringBuilder();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.content.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "Product":
                this.products.add(this.currentProduct);
                break;
            case "Name":
                this.currentProduct.setName(this.content.toString());
                break;
            case "Price":
                this.currentProduct.setPrice(Double.parseDouble(content.toString()));
                break;
            default:

        }
    }
}
