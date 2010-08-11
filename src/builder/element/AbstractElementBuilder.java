package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;
import builder.writer.info.ParagraphInfo;

import com.lowagie.text.DocumentException;

public class AbstractElementBuilder implements ElementBuilder {

	@Override
	public void process(Node node, DocumentContext context) throws DocumentException {
		if (isParagraph()) {
			context.getDocumentWriter().addParagraphToDoc(node);
			context.setParagraphInfo(new ParagraphInfo());
			modifyParagraph(node, context);
			context.getDocumentWriter().setPharagraphSettings(node);
		}

		context.pushRangeInfo();
		modifyPhrase(node, context);
		context.getDocumentWriter().setPhraseSettings(node);
	}
	public void afterProcessChilds(Node node, DocumentContext documentContext){
		documentContext.popRangeInfo();
	}

	protected void modifyParagraph(Node node, DocumentContext documentContext){
	}

	protected void modifyPhrase(Node node, DocumentContext documentContext) {
	}

	protected boolean isParagraph() {
		return false;
	}

}
