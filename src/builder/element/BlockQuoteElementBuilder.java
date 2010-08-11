package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;


public class BlockQuoteElementBuilder extends AbstractElementBuilder {
	@Override
	protected void modifyParagraph(Node node, DocumentContext documentContext){
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraphInfo().setIndentationLeft(20.0);
	}
	@Override
	protected boolean isParagraph() {
		return true;
	}
}
