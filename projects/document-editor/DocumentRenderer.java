// Client facing API
interface DocumentRenderer {
  void render(Document doc);
}

class ConsoleRenderer implements DocumentRenderer {
  public void render(Document doc) {
    StringBuilder sb = new StringBuilder();

    for (DocumentElement de: doc.getItems()) {
      sb.append(de.render());
    }

    System.out.println(sb.toString());
  }
}

class UIRenderer implements DocumentRenderer {
  public void render(Document doc) {
    System.out.println("Rendered document on connected UI");
  }
}