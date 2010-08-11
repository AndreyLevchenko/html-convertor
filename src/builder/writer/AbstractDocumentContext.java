package builder.writer;

import builder.writer.info.ParagraphInfo;
import builder.writer.info.RangeInfo;

public class AbstractDocumentContext implements DocumentContext {
	ParagraphInfo paragraphInfo=new ParagraphInfo();
	RangeInfo rangeInfo=new RangeInfo ();
	IDocumentWriter docWriter;
	/* (non-Javadoc)
	 * @see builder.writer.DocumentContext#getParagraphInfo()
	 */
	public ParagraphInfo getParagraphInfo() {
		return paragraphInfo;
	}
	/* (non-Javadoc)
	 * @see builder.writer.DocumentContext#setParagraphInfo(builder.writer.info.ParagraphInfo)
	 */
	public void setParagraphInfo(ParagraphInfo paragraphInfo) {
		this.paragraphInfo = paragraphInfo;
	}
	/* (non-Javadoc)
	 * @see builder.writer.DocumentContext#getRangeInfo()
	 */
	public RangeInfo getRangeInfo() {
		return rangeInfo;
	}
	/* (non-Javadoc)
	 * @see builder.writer.DocumentContext#setRangeInfo(builder.writer.info.RangeInfo)
	 */
	public void setRangeInfo(RangeInfo rangeInfo) {
		this.rangeInfo = rangeInfo;
	}
	public IDocumentWriter getDocWriter() {
		return docWriter;
	}
	public void setDocWriter(IDocumentWriter docWriter) {
		this.docWriter = docWriter;
	} 

}
