public class Robot {
  private Flyable flyable;
  private Walkable walkable;
  private Talkable talkable;
  private Projectable projectable;

  public Robot(
      Flyable flyable,
      Walkable walkable,
      Talkable talkable,
      Projectable projectable
  ) {
    this.flyable = flyable;
    this.walkable = walkable;
    this.talkable = talkable;
    this.projectable = projectable;
  }

  public void fly() {
    this.flyable.fly();
  }

  public void walk() {
    this.walkable.walk();
  }

  public void talk() {
    this.talkable.talk();
  }

  public void project() {
    this.projectable.project();
  }
}
