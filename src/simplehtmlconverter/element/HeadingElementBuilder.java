package simplehtmlconverter.element;

import org.w3c.dom.Node;

import simplehtmlconverter.writer.IDocumentContext;
import simplehtmlconverter.writer.info.ParagraphInfo;


public class HeadingElementBuilder extends DefaultContainerElementBuilder {
	@Override
	protected void modifyParagraph(Node node, IDocumentContext documentContext){
		super.modifyParagraph(node, documentContext);
		documentContext.getParagraphInfo().setAlignment(ParagraphInfo.ALIGNMENT_CENTER);
	}
	@Override
	protected void modifyPhrase(Node node, IDocumentContext documentContext) {
		super.modifyPhrase(node, documentContext);
		documentContext.getRangeInfo().setFontSize(14);
		documentContext.getRangeInfo().setBold(true);
	}
	@Override
	protected boolean isParagraph() {
		return true;
	}
}
