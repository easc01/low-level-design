public class Client {
  public static void main(String[] args) {
    Robot sparrowBot = new Robot(
        new Wings(),
        new Legs(),
        new NonTalkable(),
        new WhiteLight());

    System.out.println("[SparrowBot]");

    sparrowBot.fly();
    sparrowBot.walk();
    sparrowBot.talk();
    sparrowBot.project();

    System.out.println();
    System.out.println("[MyBot]");

    Robot myBot = new Robot(new Jet(), new NonWalkable(), new Morse(), new UVLight());

    myBot.fly();
    myBot.walk();
    myBot.talk();
    myBot.project();
  }
}