package builder.writer;

public abstract class AbstractDocumentWriter implements IDocumentWriter{
	private DocumentContext documentContext;

	public DocumentContext getDocumentContext() {
		return documentContext;
	}

	public void setDocumentContext(DocumentContext documentContext) {
		this.documentContext = documentContext;
	}
}
