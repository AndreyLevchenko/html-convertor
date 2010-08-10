package builder.element;


import org.w3c.dom.Node;

import builder.AbstractElementBuilder;
import builder.DocumentContext;

import com.lowagie.text.Font;

public class SmallElementBuilder extends AbstractElementBuilder {

	@Override
	protected void modifyPhrase(Node node, DocumentContext documentContext){
		super.modifyPhrase(node, documentContext);
		Font font = documentContext.getPhrase().getFont();
		font.setSize(7);
	}

}
