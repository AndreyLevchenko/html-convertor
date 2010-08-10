package builder.element;

import org.w3c.dom.Node;

import builder.AbstractElementBuilder;
import builder.DocumentContext;

import com.lowagie.text.DocumentException;


public class BlockQuoteElementBuilder extends AbstractElementBuilder {
	@Override
	protected void modifyParagraph(Node node, DocumentContext documentContext) throws DocumentException {
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraph().setIndentationLeft(20);
	}
	@Override
	protected boolean isParagraph() {
		return true;
	}
}
