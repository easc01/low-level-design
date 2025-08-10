  class OpenAI {
    private String key;

    public OpenAI(String apiKey) {
      System.out.println("Creating OpenAI client");
      this.key = apiKey;
    }

    public void sendPrompt(String prompt) {
      System.out.println("Query for prompt " + prompt + " has been resolved by key: [" + key + "]");
    }

  }

  class OpenAIClient {
    private static volatile OpenAI client;

    private OpenAIClient() {
    }

    public static OpenAI getInstance(String apiKey) {
      if (client == null) {
        synchronized (OpenAIClient.class) {
          if (client == null) {
            client = new OpenAI(apiKey);
          }
        }
      }
      return client;
    }
  }

  public class Main {
    public static void main(String[] args) {
      OpenAI client = OpenAIClient.getInstance("qweRTYUoppojHGhJkrT");
      client.sendPrompt("What is 2 + 3");

      OpenAI client2 = OpenAIClient.getInstance("234567876543");
      client2.sendPrompt("What is 3 + 2");

    }
  }
