package builder.element;

import org.w3c.dom.Node;

import builder.writer.RtfDocumentContext;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;


public class HeadingElementBuilder extends AbstractElementBuilder {
	@Override
	protected void modifyParagraph(Node node, RtfDocumentContext documentContext) throws DocumentException {
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraph().setAlignment(Paragraph.ALIGN_CENTER);
	}
	@Override
	protected void modifyPhrase(Node node, RtfDocumentContext documentContext) {
		super.modifyPhrase(node, documentContext);
		Font font = documentContext.getPhrase().getFont();
		font.setSize(14);
		font.setStyle(Font.BOLD);
	}
	@Override
	protected boolean isParagraph() {
		return true;
	}
}
