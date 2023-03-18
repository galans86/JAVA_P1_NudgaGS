package Lesson6;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class algoritmLi {

        public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    
            int x = 0;
            int y = 0;
            int nx = 0;
            int ny = 0;
    
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Document xDoc = db.parse(XmlReader.class.getResourceAsStream("data.xml"));
            Document xDoc = db.parse(new File("Lesson6/data.xml"));
            xDoc.normalize();
            NodeList nList = xDoc.getElementsByTagName("Size");
            
            Node node = nList.item(0);
            Element element = (Element) node;
    
            int height = Integer.parseInt(element.getElementsByTagName("Height").item(0).getTextContent());
            int width = Integer.parseInt(element.getElementsByTagName("Width").item(0).getTextContent());
            WaveAlg Path = new WaveAlg(width, height);
    
            nList = xDoc.getElementsByTagName("Block");
            for (int i = 0; i < nList.getLength(); i++) {
                node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    element = (Element) node;
                    x = Integer.parseInt(element.getElementsByTagName("X").item(0).getTextContent());
                    y = Integer.parseInt(element.getElementsByTagName("Y").item(0).getTextContent());
                    Path.block(x, y);
                }
            }
    
            Path.traceOut();
            System.out.println();

            x = 9;
            System.out.println("x = " + x);
            y = 1;
            System.out.println("y = " + y);
            nx = 7;
            System.out.println("nx = " + nx);
            ny = 6;
            System.out.println("ny = " + ny);

            Path.findPath(x, y, nx, ny);
    
            Path.traceOut();
            System.out.println();
    
            Path.waveOut();
        }
    
    }
