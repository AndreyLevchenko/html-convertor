import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.contenttype.ContentType;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.CTAltChunk;


public class test4 {
	public static void main(String args[]) throws Exception {
		  // Create the package

		String html = "<html><head><title>Import me</title></head><body><p>Hello World!</p></body></html>";
	    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

		AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(new PartName("/hw.html"));
		afiPart.setBinaryData(html.getBytes());
		afiPart.setContentType(new ContentType("text/html"));

		Relationship altChunkRel = wordMLPackage.getMainDocumentPart().addTargetPart(afiPart,"000");
		
		// .. the bit in document body
		
		org.docx4j.wml.ObjectFactory factory = new org.docx4j.wml.ObjectFactory();
		
		CTAltChunk ac = factory.createCTAltChunk();
		ac.setId(altChunkRel.getId());
		wordMLPackage.getMainDocumentPart().addObject(ac);

		wordMLPackage.getContentTypeManager().addDefaultContentType("html", "text/html");

	    wordMLPackage.save(new java.io.File("helloworld.docx") );
	    }

}
