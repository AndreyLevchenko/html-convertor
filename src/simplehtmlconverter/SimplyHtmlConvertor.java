package simplehtmlconverter;

import java.io.File;
import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.tidy.Tidy;

import simplehtmlconverter.element.ElementBuilder;
import simplehtmlconverter.writer.IDocumentContext;
import simplehtmlconverter.writer.RtfDocumentContext;

public class SimplyHtmlConvertor {
	RtfDocumentContext documentContext = new RtfDocumentContext();
//	Docx4jDocumentContext documentContext = new Docx4jDocumentContext();

	public void convert(InputStream is, File outputFile) throws Exception {
		documentContext.getDocumentWriter().init(outputFile);
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

	void processDomElement(Node node, IDocumentContext documentContext) throws Exception {
		ElementBuilder elementBuilder = ElementBuilderFactory.getElementBuilder(node);
		elementBuilder.process(node, documentContext);
		for (int i = 0; i < node.getChildNodes().getLength(); i++) {
			Node child = node.getChildNodes().item(i);
			processDomElement(child, documentContext);
		}
		elementBuilder.afterProcessChilds(node, documentContext);
	}

}
