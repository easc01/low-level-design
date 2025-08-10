import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

// Client facing API
interface DocumentPersistence {
  void save(Document doc);
}

class SQLPersistence implements DocumentPersistence {
  @Override
  public void save(Document doc) {
    System.out.println("Saved to SQL");
  }
}

class MongoPersistence implements DocumentPersistence {
  @Override
  public void save(Document doc) {
    System.out.println("Saved to MongoDB");
  }
}

class FilePersistence implements DocumentPersistence {
  @Override
  public void save(Document doc) {
    StringBuilder sb = new StringBuilder();

    for (DocumentElement de : doc.getItems()) {
      sb.append(de.render());
    }

    try {
      Files.write(
        Paths.get("file.txt"),
        sb.toString().getBytes(),
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING
      );
      System.out.println("Document written successfully!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}