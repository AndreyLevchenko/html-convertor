package builder.writer.info;

public class ParagraphInfo implements Cloneable{
	private Double spaceBefore; 
	private Double spaceAfter; 
	private Double indentationLeft;
	private Double indentationRight;
	private Integer alignment;
	
	public Double getIndentationLeft() {
		return indentationLeft;
	}
	public void setIndentationLeft(Double indentationLeft) {
		this.indentationLeft = indentationLeft;
	}
	public Double getIndentationRight() {
		return indentationRight;
	}
	public void setIndentationRight(Double indentationRight) {
		this.indentationRight = indentationRight;
	}
	public Double getSpaceBefore() {
		return spaceBefore;
	}
	public void setSpaceBefore(Double spaceBefore) {
		this.spaceBefore = spaceBefore;
	}
	public Double getSpaceAfter() {
		return spaceAfter;
	}
	public void setSpaceAfter(Double spaceAfter) {
		this.spaceAfter = spaceAfter;
	}
	public Integer getAlignment() {
		return alignment;
	}
	public void setAlignment(Integer alignment) {
		this.alignment = alignment;
	}
}
