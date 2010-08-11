import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import builder.DomTreeProcessor;

public class test3 {
	public static void main(String args[]) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: java ElementIteratorExample input-file");
			return;
		}

		FileInputStream fis = new FileInputStream(new File(args[0]));

		// Parse
		new DomTreeProcessor().processDomTree(fis, new File(args[1]));

	}

	public static void showElement(Element element) {
		System.out.println(element.getNodeName());
		for (int i = 0; i < element.getChildNodes().getLength(); i++) {
			Node node = element.getChildNodes().item(i);
			if (node.getNodeType() == Node.TEXT_NODE) {
				System.out.println(node.getNodeValue());
			} else {
				Element child = (Element) node;
				showElement(child);
			}
		}
	}
}
