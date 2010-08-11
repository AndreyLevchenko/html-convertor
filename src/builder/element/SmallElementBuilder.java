package builder.element;


import org.w3c.dom.Node;

import builder.writer.DocumentContext;

public class SmallElementBuilder extends AbstractElementBuilder {

	@Override
	protected void modifyPhrase(Node node, DocumentContext documentContext){
		super.modifyPhrase(node, documentContext);
		documentContext.getRangeInfo().setFontSize(7);
	}

}
