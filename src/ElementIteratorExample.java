/*
Definitive Guide to Swing for Java 2, Second Edition
By John Zukowski     
ISBN: 1-893115-78-X
Publisher: APress
*/

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ElementIteratorExample {

  public static void main(String args[]) throws Exception {

    if (args.length != 1) {
      System.err.println("Usage: java ElementIteratorExample input-file");
      return;
    }

    // Load HTML file 
    File f = new File(args[0]);


    // Parse
    Element root=loadDocument(f);
    
  	showElement(root);
    	
    System.exit(0);
  }
  public static Element loadDocument(File f)  throws Exception {
  Document doc = null;
  try {
    doc = getDocumentBuilder().parse(f);
    return doc.getDocumentElement();
  } catch (Exception se) {
    throw new Exception(se.getMessage());
  }
}  
public static void showElement(Element element) {
	System.out.println(element.getNodeName());
	for(int i=0;i<element.getChildNodes().getLength();i++) {
		Node node =element.getChildNodes().item(i);
		Element child=(Element)node;
		showElement(child);
	}
}
public static DocumentBuilder getDocumentBuilder() throws Exception {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      dbf.setIgnoringComments(true);
      dbf.setCoalescing(true);
      dbf.setIgnoringElementContentWhitespace(true);
      dbf.setValidating(false);
      return dbf.newDocumentBuilder();
    } catch (Exception exc) {
      throw new Exception(exc.getMessage());
    }
  }
}