import java.util.*;
import java.io.*;

public class MyGraph {

  // ArrayListのi番目にnode<i>に対応するEdgeのListが格納されている
  ArrayList<LinkedList<MyEdge>> nodes;

  public void ReadFromFile(String filename) {
    try {
      File inputFile = new File(filename);
      Scanner sc = new Scanner(inputFile);
      // 1行目はグラフの頂点数 V
      int v = Integer.parseInt(sc.nextLine());
      nodes = new ArrayList<LinkedList<MyEdge>>(v);
      for (int i = 0; i <= v; i++) {
        nodes.add(new LinkedList<MyEdge>());
      }
      // 2行目はグラフの枝数 E
      int e = Integer.parseInt(sc.nextLine());
      while (sc.hasNext()) {
        String edgeInfo = sc.nextLine();
        String[] tmp = edgeInfo.split(" ", 3);
        addEdge(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]));
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Filename: " + filename + " is not found");
      System.exit(0);
    } catch (InputMismatchException ex) {
      System.out.println("整数ではない値が含まれています");
      System.exit(0);
    } catch (NumberFormatException ex) {
      System.out.println("整数ではない値が含まれています");
      System.exit(0);
    }
  }
  public void addEdge(int v, int w, int weight){
    try {
      nodes.get(v).add(new MyEdge(w, weight));
    } catch (IndexOutOfBoundsException e) {
      LinkedList<MyEdge> l = new LinkedList<MyEdge>();
      l.add(new MyEdge(w, weight));
      nodes.set(v, l);
    }
    try {
      nodes.get(w).add(new MyEdge(v, weight));
    } catch (IndexOutOfBoundsException e) {
      LinkedList<MyEdge> l = new LinkedList<MyEdge>();
      l.add(new MyEdge(v, weight));
      nodes.set(w, l);
    }
  }
  public LinkedList<MyEdge> getEdges(int id) {
    return nodes.get(id);
  }
}
