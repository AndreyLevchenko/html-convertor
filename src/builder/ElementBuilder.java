package builder;

import org.w3c.dom.Node;

import com.lowagie.text.DocumentException;

public interface ElementBuilder {
	public abstract void  process(Node node, DocumentContext context) throws DocumentException ;

}
