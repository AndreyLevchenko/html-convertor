package simplehtmlconverter.element;

import org.w3c.dom.Node;

import simplehtmlconverter.writer.IDocumentContext;

public class BrElementBuilder implements ElementBuilder {

	@Override
	public void process(Node node, IDocumentContext documentContext) {
		documentContext.getDocumentWriter().addSoftLineBreak(node);
	}

	@Override
	public void afterProcessChilds(Node node, IDocumentContext documentContext) {
	}

}
