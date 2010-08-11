package builder.writer;

import builder.writer.info.ParagraphInfo;
import builder.writer.info.RangeInfo;

public interface DocumentContext {

	public abstract ParagraphInfo getParagraphInfo();

	public abstract void setParagraphInfo(ParagraphInfo paragraphInfo);

	public abstract RangeInfo getRangeInfo();

	public abstract void setRangeInfo(RangeInfo rangeInfo);

	public abstract IDocumentWriter getDocumentWriter();

	public void popRangeInfo();
	public void pushRangeInfo();

}