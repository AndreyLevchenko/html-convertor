package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;
import builder.writer.info.ParagraphInfo;


public class HeadingElementBuilder extends AbstractElementBuilder {
	@Override
	protected void modifyParagraph(Node node, DocumentContext documentContext){
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraphInfo().setAlignment(ParagraphInfo.ALIGNMENT_CENTER);
	}
	@Override
	protected void modifyPhrase(Node node, DocumentContext documentContext) {
		super.modifyPhrase(node, documentContext);
		documentContext.getRangeInfo().setFontSize(14);
		documentContext.getRangeInfo().setBold(true);
	}
	@Override
	protected boolean isParagraph() {
		return true;
	}
}
