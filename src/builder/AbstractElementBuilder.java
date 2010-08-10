package builder;

import org.w3c.dom.Node;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

public class AbstractElementBuilder implements ElementBuilder {

	@Override
	public void process(Node node, DocumentContext context) throws DocumentException {
		modifyParagraph(node, context);
		modifyPhrase(node, context);
	}

	protected void modifyParagraph(Node node, DocumentContext documentContext) throws DocumentException {
		if (isParagraph() || documentContext.getParagraph() == null) {
			if (documentContext.getParagraph() != null) {
				documentContext.getDocument().add(documentContext.getParagraph());
			}
			Paragraph p = new Paragraph();
			p.setSpacingAfter(10);
			documentContext.setParagraph(p);
		}

	}

	protected void modifyPhrase(Node node, DocumentContext documentContext) {
		documentContext.setPhrase(new Phrase());
	}

	protected boolean isParagraph() {
		return false;
	}

}
