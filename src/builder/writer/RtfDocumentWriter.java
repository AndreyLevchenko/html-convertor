package builder.writer;

import org.w3c.dom.Node;

import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.direct.RtfDirectContent;

public class RtfDocumentWriter extends AbstractDocumentWriter {
	private RtfDocumentContext docContext;
	public DocumentContext getDocumentContext() {
		return (DocumentContext)documentContext;
	}

	public void setDocumentContext(DocumentContext documentContext) {
		this.documentContext = (DocumentContext)documentContext;
	}
	

	@Override
	public void addParagraphToDoc(Node node) {
		if (isParagraph() || context.getParagraph() == null) {
			if (context.getParagraph() != null) {
				context.getDocument().add(context.getParagraph());
			}
			Paragraph p = new Paragraph();
			p.setSpacingAfter(10);
			context.setParagraph(p);
		}
	}

	@Override
	public void addPhraseToParagraph(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSoftLineBreak(Node node) {
		RtfDirectContent br =new RtfDirectContent("\\line"); 
		documentContext.getParagraph().add(br);
	}

	@Override
	public void addText(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPharagraphSettings(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPhraseSettings(Node node) {
		// TODO Auto-generated method stub

	}

}
