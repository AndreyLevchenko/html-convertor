package builder.element;

import org.w3c.dom.Node;

import builder.writer.DocumentContext;

import com.lowagie.text.DocumentException;

public interface ElementBuilder {
	public abstract void  process(Node node, DocumentContext context) throws DocumentException ;
	public void afterProcessChilds(Node node, DocumentContext documentContext);
}
