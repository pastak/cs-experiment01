public class MyEdge {
  int id;
  int weight;
  MyEdge (int id, int weight) {
    this.id = id;
    this.weight = weight;
  }

  public String toString () {
    return String.format("%d %d", this.id, this.weight);
  }
}
