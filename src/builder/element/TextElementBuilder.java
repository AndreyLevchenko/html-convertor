package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;

public class TextElementBuilder extends AbstractElementBuilder {

	@Override
	public void process(Node node, DocumentContext documentContext) {
		documentContext.getDocumentWriter().setPhraseSettings(node);
		documentContext.getDocumentWriter().addText(node.getNodeValue());
	}

}
