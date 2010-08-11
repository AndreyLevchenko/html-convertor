package builder.writer.info;

public class RangeInfo implements Cloneable {
	private String fontName;
	private Integer fontSize;
	private Boolean bold;
	private Boolean italic;
	private Boolean underline;
	private Boolean subscript;
	private Boolean superscript;
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public Integer getFontSize() {
		return fontSize;
	}
	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}
	public Boolean getBold() {
		return bold;
	}
	public void setBold(Boolean bold) {
		this.bold = bold;
	}
	public Boolean getItalic() {
		return italic;
	}
	public void setItalic(Boolean italic) {
		this.italic = italic;
	}
	public Boolean getUnderline() {
		return underline;
	}
	public void setUnderline(Boolean underline) {
		this.underline = underline;
	}
	public Boolean getSubscript() {
		return subscript;
	}
	public void setSubscript(Boolean subscript) {
		this.subscript = subscript;
	}
	public Boolean getSuperscript() {
		return superscript;
	}
	public void setSuperscript(Boolean superscript) {
		this.superscript = superscript;
	}
}
