import java.io.File;
import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;


public class test2 {
	public static void main(String args[]) throws Exception {
		HtmlCleaner cleaner = new HtmlCleaner();
	    File f = new File(args[0]);
	    
		TagNode doc = cleaner.clean(f);
		List foundNodes=doc.getElementListByName("body", true);
		TagNode body =(TagNode)foundNodes.get(0);
		showElement(body);
		}
	
	public static void showElement(TagNode node ) {
		System.out.println(node.getName()+":"+node.getText());
		for(TagNode child: node.getAllElements(false)) {
			showElement(child);
		}
	}
	
}
