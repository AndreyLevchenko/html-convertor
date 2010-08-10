package builder.element;

import org.w3c.dom.Node;

import builder.AbstractElementBuilder;
import builder.DocumentContext;

import com.lowagie.text.rtf.direct.RtfDirectContent;

public class BrElementBuilder extends AbstractElementBuilder {

	@Override
	public void process(Node node, DocumentContext documentContext) {
		RtfDirectContent br =new RtfDirectContent("\\line"); 
		documentContext.getParagraph().add(br);
	}

}
