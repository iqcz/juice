package com.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 解析xml配置文件
 *
 * @author i324779
 */
public class XmlUtil {

    public static Object getBean() {
        Object object = "";

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document document;

            document = builder.parse(new File("src/main/java/com/xml/config.xml"));

            NodeList nodeList = document.getElementsByTagName("name");
            Node classNode = nodeList.item(0).getFirstChild();

            String name = classNode.getNodeValue().trim();

            Class clazz = Class.forName(name);

            object = clazz.newInstance();

        } catch (ParserConfigurationException | IOException
                | SAXException | ClassNotFoundException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return object;
    }
}
