import java.util.*;
import java.io.*;

public class MyGraphTest {
  public static void main(String[] args) {
    MyGraph graph = new MyGraph();
    Scanner scan = new Scanner(System.in);
    System.out.print("Type your input file name: ");
    String intputFileName = scan.next();
    try {
      graph.ReadFromFile(intputFileName);
      System.out.print("edge id?: ");
      LinkedList<MyEdge> edges = graph.getEdges(scan.nextInt());
      for (MyEdge edge: edges) {
        System.out.println(edge);
      }
    } catch (NullPointerException e) {}
      catch (InputMismatchException ex) {
        System.out.println("整数ではない値が含まれています");
        System.exit(0);
      }
  }
}
