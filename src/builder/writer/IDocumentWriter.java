package builder.writer;

import java.io.File;

import org.w3c.dom.Node;


public interface IDocumentWriter {
	public DocumentContext getDocumentContext();
	public void setDocumentContext(DocumentContext documentContext);
	public void addSoftLineBreak(Node node);
	public void addParagraphToDoc(Node node);
	public void addPhraseToParagraph(Node node);
	public void setPharagraphSettings(Node node);
	public void setPhraseSettings(Node node);
	public void addText(String text);
	public void init(File outputFile);
	public void close();

}
