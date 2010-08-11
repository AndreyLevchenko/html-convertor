package builder.element;

import org.w3c.dom.Node;

import builder.writer.RtfDocumentContext;

import com.lowagie.text.DocumentException;


public class BlockQuoteElementBuilder extends AbstractElementBuilder {
	@Override
	protected void modifyParagraph(Node node, RtfDocumentContext documentContext) throws DocumentException {
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraph().setIndentationLeft(20);
	}
	@Override
	protected boolean isParagraph() {
		return true;
	}
}
