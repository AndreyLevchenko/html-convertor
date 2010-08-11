package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;

public class BrElementBuilder extends AbstractElementBuilder {

	@Override
	public void process(Node node, DocumentContext documentContext) {
		documentContext.getDocumentWriter().addSoftLineBreak(node);
	}

}
