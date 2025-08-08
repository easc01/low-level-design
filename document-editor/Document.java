import java.util.*;

class Document {
  private List<DocumentElement> items;

  public Document() {
    this.items = new ArrayList<>();
  }

  public Document(List<DocumentElement> items) {
    this.items = items;
  }

  public int getSize() {
    return items.size();
  }

  public void addElement(DocumentElement de) {
    items.add(de);
  }

  public DocumentElement getItem(int idx) {
    return items.get(idx);
  }

  public List<DocumentElement> getItems() {
    return this.items;
  }

  public DocumentElement removeItem(int idx) {
    DocumentElement item = getItem(idx);
    items.remove(idx);
    return item;
  }
}

// Client facing API
class DocumentEditor {
  Document document;
  DocumentPersistence persistence;
  DocumentRenderer renderer;

  public DocumentEditor(Document document) {
    this.document = document;
  }

  public DocumentEditor(Document doc, DocumentPersistence persistence) {
    this.document = doc;
    this.persistence = persistence;
  }

  public DocumentEditor(Document doc, DocumentPersistence persistence, DocumentRenderer renderer) {
    this.document = doc;
    this.persistence = persistence;
    this.renderer = renderer;
  }

  public void addText(String text) {
    document.addElement(new TextElement(text));
  }

  public void addImage(String imagePath) {
    document.addElement(new ImageElement(imagePath));
  }

  public void addNewLine() {
    document.addElement(new NewLineElement());
  }

  public void addTabSpace() {
    document.addElement(new TabSpaceElement());
  }

  public void renderDocument() {
    this.renderer.render(document);
  }

  public void renderDocument(DocumentRenderer dr) {
    dr.render(document);
  }

  public void saveDocument() {
    persistence.save(document);
  }

  public void saveDocument(DocumentPersistence persistence) {
    persistence.save(document);
  }
}