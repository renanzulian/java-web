package com.renanzulian.xmlproject.sax;

import com.renanzulian.xmlproject.models.Product;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLEventReaderSax {
    public static void main(String[] args) throws Exception {

        InputStream inputStream = new FileInputStream("src/sales.xml");
        XMLEventReader events = XMLInputFactory.newInstance().createXMLEventReader(inputStream);
        List<Product> products = new ArrayList<>();

        while(events.hasNext()){
            XMLEvent event = events.nextEvent();

            if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("Product")) {
                Product product = ProcessProduct(events);
                products.add(product);
            }
        }

        System.out.println(products);

    }

    private static Product ProcessProduct(XMLEventReader events) throws Exception {

        Product product = new Product();

        while(events.hasNext()) {
            XMLEvent event = events.nextEvent();
            if(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("Product")) {
                break;
            }

            if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("Name")) {
                event = events.nextEvent();
                String nome = event.asCharacters().getData();
                product.setName(nome);
            }

            if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("Price")) {
                event = events.nextEvent();
                Double price = Double.parseDouble(event.asCharacters().getData());
                product.setPrice(price);
            }

        }

        return product;
    }
}
