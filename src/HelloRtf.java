import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * Generates an RTF document with the text 'Hello'
 * 
 * @author Mark Hall
 */
public class HelloRtf {
    
	/**
	 * Creates an RTF file.
	 * 
	 * @param args some text. For instance: if you add 'World' as argument, the RTF will contain the text 'Hello World'.
	 */
	public static void main(String[] args) throws Exception {
        
		System.out.println("Hello World example in RTF");
        
		// step 1: creation of a document-object
		Document document = new Document();
        
		// step 2:
		// we create a writer that listens to the document
		// and directs a RTF-stream to a file
            
		RtfWriter2.getInstance(document, new FileOutputStream("HelloWorld.doc"));
            
		// step 3: we open the document
		document.open();
            
		// step 4: we add a paragraph to the document
		Paragraph p = new Paragraph("Hello");
		Phrase ph1=new Phrase("bold");
		ph1.getFont().setStyle(Font.BOLD);
		Phrase ph2=new Phrase(" plain"); 
		p.add(ph1);
		p.add(ph2);
		
		document.add(p);
	
        
		// step 5: we close the document
		document.close();
	}
}