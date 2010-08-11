package builder;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import builder.element.AbstractElementBuilder;
import builder.element.BlockQuoteElementBuilder;
import builder.element.BoldElementBuilder;
import builder.element.BrElementBuilder;
import builder.element.CenterElementBuilder;
import builder.element.ElementBuilder;
import builder.element.HeadingElementBuilder;
import builder.element.ItalicElementBuilder;
import builder.element.ParagraphElementBuilder;
import builder.element.SmallElementBuilder;
import builder.element.SuperScriptElementBuilder;
import builder.element.TextElementBuilder;


public class ElementBuilderFactory {
	private static Map<String, ElementBuilder> elementBuilders = new HashMap<String, ElementBuilder>(); 
	static {
		elementBuilders.put("b",new BoldElementBuilder());
		elementBuilders.put("br",new BrElementBuilder());
		elementBuilders.put("p",new ParagraphElementBuilder());
		elementBuilders.put("center",new CenterElementBuilder());
		elementBuilders.put("h3",new HeadingElementBuilder());
		elementBuilders.put("i",new ItalicElementBuilder());
		elementBuilders.put("blockquote",new BlockQuoteElementBuilder());
		elementBuilders.put("small",new SmallElementBuilder());
		elementBuilders.put("sup",new SuperScriptElementBuilder());
	}
	public static ElementBuilder getElementBuilder(Node node) {
		ElementBuilder elementBuilder = null;
		if (node.getNodeType()==Element.TEXT_NODE) {
			return new TextElementBuilder();
		}
		String nodeType=node.getNodeName();
		if (elementBuilders.containsKey(nodeType)) {
			elementBuilder=elementBuilders.get(nodeType);
		}else {
			elementBuilder=new AbstractElementBuilder();
			System.out.println(nodeType+"(default)");
		}
		return elementBuilder;
	}

}
