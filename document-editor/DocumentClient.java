public class DocumentClient {
  public static void main(String[] args) {
    DocumentEditor editor = new DocumentEditor(new Document());

    editor.addText("Hello, world!");
    editor.addNewLine();
    editor.addText("This is a real-world document editor example.");
    editor.addNewLine();
    editor.addTabSpace();
    editor.addText("Indented text after a tab space.");
    editor.addNewLine();
    editor.addImage("picture.jpg");

    editor.renderDocument(new ConsoleRenderer());
    editor.saveDocument(new FilePersistence());
    editor.saveDocument(new SQLPersistence());
    editor.saveDocument(new MongoPersistence());
  }
}