package simplehtmlconverter.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.w3c.dom.Node;

import simplehtmlconverter.util.HtmlUtil;
import simplehtmlconverter.writer.info.ParagraphInfo;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.rtf.RtfWriter2;
import com.lowagie.text.rtf.direct.RtfDirectContent;

public class RtfDocumentWriter implements IDocumentWriter {
	private RtfDocumentContext documentContext;

	public IDocumentContext getDocumentContext() {
		return (IDocumentContext) documentContext;
	}

	public void setDocumentContext(IDocumentContext documentContext) {
		this.documentContext = (RtfDocumentContext) documentContext;
	}

	@Override
	public void addParagraphToDoc(Node node) {
		if (documentContext.getParagraph() != null) {
			try {
				documentContext.getDocument().add(documentContext.getParagraph());
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Paragraph p = new Paragraph();
		p.setSpacingAfter(10);
		documentContext.setParagraph(p);
	}

	@Override
	public void addPhraseToParagraph(Node node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSoftLineBreak(Node node) {
		RtfDirectContent br = new RtfDirectContent("\\line");
		documentContext.getParagraph().add(br);
	}

	@Override
	public void addText(String text) {
		Phrase tmpPhrase=(Phrase)documentContext.getPhrase().clone();
		tmpPhrase.add(HtmlUtil.decodeHTMLEntities(text));
		documentContext.getParagraph().add(tmpPhrase);
	}

	@Override
	public void setPharagraphSettings(Node node) {
		if (documentContext.getParagraphInfo().getIndentationLeft() != null) {
			documentContext.getParagraph().setIndentationLeft(
					documentContext.getParagraphInfo().getIndentationLeft().floatValue());
		}
		if (documentContext.getParagraphInfo().getAlignment() == ParagraphInfo.ALIGNMENT_CENTER) {
			documentContext.getParagraph().setAlignment(Paragraph.ALIGN_CENTER);
		}
	}

	@Override
	public void setPhraseSettings(Node node) {
		documentContext.setPhrase(new Phrase());
		Font font = documentContext.getPhrase().getFont();
		if (documentContext.getRangeInfo().getBold()) {
			font.setStyle(Font.BOLD);
		} else {
			// TODO use inversion of Bold
			// int currentStyle = font.getStyle();
			// font.setStyle(currentStyle & ~Font.BOLD);
			font.setStyle(Font.NORMAL);
		}

		if (documentContext.getRangeInfo().getItalic() != null && documentContext.getRangeInfo().getItalic()) {
			font.setStyle(Font.ITALIC);
		} else {
			// TODO use inversion of Bold
		}
		Integer fontSize = documentContext.getRangeInfo().getFontSize();
		if (fontSize != null) {
			font.setSize(fontSize);
		}

	}

	@Override
	public void close() {
		try {
			documentContext.getDocument().add(documentContext.getParagraph());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		documentContext.getDocument().close();
	}

	@Override
	public void init(File outputFile) {
		OutputStream outputStream=null;
		try {
			outputStream = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RtfWriter2.getInstance(documentContext.getDocument(), outputStream);
		documentContext.getDocument().open();
	}

}
