package builder.element;

import org.w3c.dom.Node;

import builder.AbstractElementBuilder;
import builder.DocumentContext;

import com.lowagie.text.Phrase;

public class TextElementBuilder extends AbstractElementBuilder {

	@Override
	public void process(Node node, DocumentContext documentContext) {
				Phrase tmpPhrase=(Phrase)documentContext.getPhrase().clone();
				tmpPhrase.add(node.getNodeValue());
				documentContext.getParagraph().add(tmpPhrase);
	}

}
