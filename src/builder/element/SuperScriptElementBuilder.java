package builder.element;


import org.w3c.dom.Node;

import builder.AbstractElementBuilder;
import builder.DocumentContext;

import com.lowagie.text.Chunk;

public class SuperScriptElementBuilder extends AbstractElementBuilder {

	@Override
	protected void modifyPhrase(Node node, DocumentContext documentContext){
		super.modifyPhrase(node, documentContext);
		Chunk ch = new Chunk();
		ch.setTextRise(10);
		documentContext.getPhrase().add(ch);
		// this doesn't work. Chunk should be added to document context and TextElementBuilder should be modified to use chunk if it exists 
	}

}