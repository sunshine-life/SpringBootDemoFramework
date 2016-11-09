package com.example.utils;

import org.apache.commons.io.IOUtils;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by life on 16-10-24.
 */
public class GetProductConfig {

    public static Document parse(String xmlFilePath){
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = (Document) reader.read(new File(xmlFilePath));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return doc;
    }


    public static Document testParseXmlData(String xmlFilePath) throws IOException {
        //jsoup解析xml
        InputStream resourceAsStream = GetProductConfig.class.getResourceAsStream(xmlFilePath);
        String xml = IOUtils.toString(resourceAsStream);
        Document document = Jsoup.parse(xml);

        //SAX解析xml
       /* InputStream is = GetProductConfig.class.getResourceAsStream(xmlFilePath);
        SAXBuilder sax = new SAXBuilder();
        Document doc = (Document) sax.build(is);

        Element root = doc.getRootElement();//获得根节点
        List<Element> list = root.getChildren();
        for(Element e:list) {
            System.out.println("name="+e.getName());
            System.out.println("limitetotal="+e.getChildText("limitetotal"));
            System.out.println("limitenum="+e.getChildText("limitenum"));
            System.out.println("status="+e.getChildText("status"));
            System.out.println("================================================================");
            System.out.println(e.getValue());
            System.out.println(e.getAttribute("limitetotal"));
            System.out.println(e.getAttributes().toString());
        }*/
        return document;
    }
}
