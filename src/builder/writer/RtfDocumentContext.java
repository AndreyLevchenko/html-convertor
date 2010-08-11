package builder.writer;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;

public class RtfDocumentContext extends AbstractDocumentContext  {
	private Document document=new Document();
	private Paragraph paragraph;
	private Phrase phrase = new Phrase();
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Paragraph getParagraph() {
		return paragraph;
	}
	public void setParagraph(Paragraph paragraph) {
		this.paragraph = paragraph;
	}
	public Phrase getPhrase() {
		return phrase;
	}
	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
	}
}
