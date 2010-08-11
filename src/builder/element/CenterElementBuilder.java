package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;
import builder.writer.info.ParagraphInfo;

public class CenterElementBuilder extends AbstractElementBuilder {
	@Override
	protected boolean isParagraph() {
		return true;
	}
	@Override
	protected void modifyParagraph(Node node, DocumentContext documentContext) {
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraphInfo().setAlignment(ParagraphInfo.ALIGNMENT_CENTER);
	}
}
