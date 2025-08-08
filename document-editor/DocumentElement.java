interface DocumentElement {
  String render();
}

class TextElement implements DocumentElement {
  private String text;

  public TextElement(String text) {
    this.text = text;
  }

  @Override
  public String render() {
    return this.text;
  }
}

class ImageElement implements DocumentElement {
  private String imagePath;

  public ImageElement(String imagePath) {
    this.imagePath = imagePath;
  }

  @Override
  public String render() {
    return "[Image]: " + imagePath;
  }
}

class NewLineElement implements DocumentElement {
  @Override
  public String render() {
    return "\n";
  }
}

class TabSpaceElement implements DocumentElement {
  @Override
  public String render() {
    return "\t";
  }
}
