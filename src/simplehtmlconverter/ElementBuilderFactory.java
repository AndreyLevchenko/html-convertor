package simplehtmlconverter;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import simplehtmlconverter.element.DefaultContainerElementBuilder;
import simplehtmlconverter.element.BlockQuoteElementBuilder;
import simplehtmlconverter.element.BoldElementBuilder;
import simplehtmlconverter.element.BrElementBuilder;
import simplehtmlconverter.element.CenterElementBuilder;
import simplehtmlconverter.element.ElementBuilder;
import simplehtmlconverter.element.HeadingElementBuilder;
import simplehtmlconverter.element.ItalicElementBuilder;
import simplehtmlconverter.element.ParagraphElementBuilder;
import simplehtmlconverter.element.SmallElementBuilder;
import simplehtmlconverter.element.SuperScriptElementBuilder;
import simplehtmlconverter.element.TextElementBuilder;


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
			System.out.println(nodeType);
		}else {
			elementBuilder=new DefaultContainerElementBuilder();
			System.out.println(nodeType+"(default)");
		}
		return elementBuilder;
	}

}
