interface Flyable {
  void fly();  
}

interface Walkable {
  void walk();
}

interface Talkable {
  void talk();
}

interface Projectable {
  void project();
}

class Jet implements Flyable {
  @Override
  public void fly() {
    System.out.println("Flying via Jet");
  }
}

class Wings implements Flyable {
  @Override
  public void fly() {
    System.out.println("Flying via Wings");
  }
}

class NonFlyable implements Flyable {
  @Override
  public void fly() {
    System.out.println("Cannot fly");
  }
}

class NonWalkable implements Walkable {
  @Override
  public void walk() {
    System.out.println("Cannot walk");
  }
}

class Legs implements Walkable {
  @Override
  public void walk() {
    System.out.println("Walk via legs");
  }
}

class Roller implements Walkable {
  @Override
  public void walk() {
    System.out.println("Walk via roller skates");
  }
}

class NonTalkable implements Talkable {
  @Override
  public void talk() {
    System.out.println("Cannot talk");
  }
}

class Speaker implements Talkable {
  @Override
  public void talk() {
    System.out.println("Talk via Speaker");
  }
}

class Signs implements Talkable {
  @Override
  public void talk() {
    System.out.println("Talk via Sign language");
  }
}

class Morse implements Talkable {
  @Override
  public void talk() {
    System.out.println("Talk via Morse code");
  }
}

class WhiteLight implements Projectable {
  @Override
  public void project() {
    System.out.println("Project via white light");
  }
}

class UVLight implements Projectable {
  @Override
  public void project() {
    System.out.println("Project via UV light");
  }
}