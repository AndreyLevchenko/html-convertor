package builder.element;


import org.w3c.dom.Node;

import builder.writer.RtfDocumentContext;

import com.lowagie.text.Font;

public class BoldElementBuilder extends AbstractElementBuilder {

	@Override
	protected void modifyPhrase(Node node, RtfDocumentContext documentContext){
		super.modifyPhrase(node, documentContext);
		Font font = documentContext.getPhrase().getFont();
		font.setStyle(Font.BOLD);
	}

}
