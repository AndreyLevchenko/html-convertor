package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;

public class TextElementBuilder implements ElementBuilder {

	@Override
	public void process(Node node, DocumentContext documentContext) {
		documentContext.getDocumentWriter().setPhraseSettings(node);
		documentContext.getDocumentWriter().addText(node.getNodeValue());
	}

	@Override
	public void afterProcessChilds(Node node, DocumentContext documentContext) {
		// TODO Auto-generated method stub
		
	}

}
