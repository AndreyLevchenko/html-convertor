package builder.element;

import org.w3c.dom.Node;

import builder.writer.RtfDocumentContext;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;

public class CenterElementBuilder extends AbstractElementBuilder {
	@Override
	protected boolean isParagraph() {
		return true;
	}
	@Override
	protected void modifyParagraph(Node node, RtfDocumentContext documentContext) throws DocumentException {
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraph().setAlignment(Paragraph.ALIGN_CENTER);
	}
}
