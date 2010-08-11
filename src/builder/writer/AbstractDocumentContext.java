package builder.writer;

import java.util.Stack;

import builder.writer.info.ParagraphInfo;
import builder.writer.info.RangeInfo;

public abstract class AbstractDocumentContext implements DocumentContext {
	private ParagraphInfo paragraphInfo = new ParagraphInfo();
	private RangeInfo rangeInfo = new RangeInfo();
	private Stack<RangeInfo> rangeInfoStack = new Stack<RangeInfo>();

	public void popRangeInfo() {
		if (rangeInfoStack.size()>0) { 
			rangeInfo=rangeInfoStack.pop();
		}
	}

	public void pushRangeInfo() {
		RangeInfo storedRangeInfo=null;
		try {
			storedRangeInfo = (RangeInfo)rangeInfo.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rangeInfoStack.push(storedRangeInfo);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see builder.writer.DocumentContext#getParagraphInfo()
	 */
	public ParagraphInfo getParagraphInfo() {
		return paragraphInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seebuilder.writer.DocumentContext#setParagraphInfo(builder.writer.info.
	 * ParagraphInfo)
	 */
	public void setParagraphInfo(ParagraphInfo paragraphInfo) {
		this.paragraphInfo = paragraphInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see builder.writer.DocumentContext#getRangeInfo()
	 */
	public RangeInfo getRangeInfo() {
		return rangeInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * builder.writer.DocumentContext#setRangeInfo(builder.writer.info.RangeInfo
	 * )
	 */
	public void setRangeInfo(RangeInfo rangeInfo) {
		this.rangeInfo = rangeInfo;
	}

	public abstract IDocumentWriter getDocumentWriter();
}
