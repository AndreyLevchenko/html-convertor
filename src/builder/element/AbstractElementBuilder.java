package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;
import builder.writer.RtfDocumentContext;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

public class AbstractElementBuilder implements ElementBuilder {

	@Override
	public void process(Node node, DocumentContext context) throws DocumentException {
		if (isParagraph() || context.getParagraph() == null) {
			if (context.getParagraph() != null) {
				context.getDocument().add(context.getParagraph());
			}
			Paragraph p = new Paragraph();
			p.setSpacingAfter(10);
			context.setParagraph(p);
		}
		modifyParagraph(node, context);

		context.setPhrase(new Phrase());
		
		modifyPhrase(node, context);
	}

	protected void modifyParagraph(Node node, DocumentContext documentContext) throws DocumentException {
	}

	protected void modifyPhrase(Node node, DocumentContext documentContext) {
	}

	protected boolean isParagraph() {
		return false;
	}

}
