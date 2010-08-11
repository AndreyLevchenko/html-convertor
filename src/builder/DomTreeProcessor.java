package builder;

import java.io.InputStream;
import java.io.OutputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.tidy.Tidy;

import builder.element.ElementBuilder;
import builder.writer.RtfDocumentContext;

public class DomTreeProcessor {
	RtfDocumentContext documentContext = new RtfDocumentContext();

	public void processDomTree(InputStream is, OutputStream os) throws Exception {
		documentContext.getDocumentWriter().init(os);
		Element root = loadDocument(is);
		processDomElement(root, documentContext);
		documentContext.getDocumentWriter().close();
	}

	private Element loadDocument(InputStream is) throws Exception {

		Document doc = null;
		try {
			Tidy tidy = new Tidy();
			tidy.setShowWarnings(false);
			tidy.setQuiet(true);
			doc = tidy.parseDOM(is, null);
			return doc.getDocumentElement();
		} catch (Exception se) {
			throw new Exception(se.getMessage());
		}
	}

	void processDomElement(Node node, RtfDocumentContext documentContext) throws Exception {
		ElementBuilder elementBuilder = ElementBuilderFactory.getElementBuilder(node);
		elementBuilder.process(node, documentContext);
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node child = node.getChildNodes().item(i);
			processDomElement(child, documentContext);
		}
		elementBuilder.afterProcessChilds(node, documentContext);
	}

}
