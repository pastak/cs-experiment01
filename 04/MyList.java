import java.util.*;
import java.io.*;

public class MyList {
  public static void insert(int x, ArrayList<Integer> l) {
    int i = 0;
    while(i < l.size() && x > l.get(i)) i++;
    l.add(i, x);
  }

  public static void delete(int x, ArrayList<Integer> l) {
    int index;
    while ((index = l.indexOf(x)) > -1) {
      l.remove(index);
    }
  }

  public static void output(ArrayList<Integer> l) {
    for (int i = 0; i < l.size(); i++) {
      System.out.print("" + l.get(i) + " ");
    }
    System.out.print("\n");
  }
}
