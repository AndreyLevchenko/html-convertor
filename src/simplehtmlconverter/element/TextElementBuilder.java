package simplehtmlconverter.element;

import org.w3c.dom.Node;

import simplehtmlconverter.writer.IDocumentContext;

public class TextElementBuilder implements ElementBuilder {

	@Override
	public void process(Node node, IDocumentContext documentContext) {
		documentContext.getDocumentWriter().setPhraseSettings(node);
		documentContext.getDocumentWriter().addText(node.getNodeValue());
	}

	@Override
	public void afterProcessChilds(Node node, IDocumentContext documentContext) {
		// TODO Auto-generated method stub
		
	}

}
