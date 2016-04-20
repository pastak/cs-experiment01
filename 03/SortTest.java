import java.util.*;
import java.io.*;

public class SortTest {
  public static int[] input() {
    // 標準入力からの入力ファイル名を受け取り，入力ファイル内のソート対象データを配列に格納し，得られた配列を返す．
    Scanner scan = new Scanner(System.in);
    System.out.print("Type your input file name: ");
    String intputFileName = scan.next();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    try {
      File inputFile = new File(intputFileName);
      Scanner sc = new Scanner(inputFile);
      while (sc.hasNext()) {
        int num = sc.nextInt();
        numbers.add(num);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("Filename: " + intputFileName + " is not found");
      return null;
    }
    try {
      return validate(numbers);
    } catch (IllegalStateException ex) {
      System.out.println("入力ファイルの内容が不正です: "+ex.getMessage());
      return null;
    }
  }
  public static int[] validate (ArrayList<Integer> numbers) {
    if (numbers.size() > 50) {
      throw new IllegalStateException("読み込むことが出来る値の個数は50個以下です");
    }
    int[] res = new int[numbers.size()];
    for (int i = 0; i < numbers.size(); i++) {
      int num = numbers.get(i);
      if (num < 1 || num > 9999) throw new IllegalStateException("入力可能な値は自然数で1以上9999以下です");
      res[i] = num;
    }
    return res;
  }
  public static void output(int[] array) {
    // ソートされたデータを画面に出力する．
    int counter = 1;
    for (int num : array) {
      if (num == 0) continue;
      System.out.print(rightJustify(num));
      if (counter % 10 == 0) {
        System.out.print("\n");
      } else if (counter != array.length) {
        System.out.print(" ");
      }
      counter++;
    }
  }

  public static String rightJustify (int num) {
    String num_string = "" + num;
    int spaces = 4 - num_string.length();
    for (int i = 0; i < spaces; i++) {
      num_string = " " + num_string;
    }
    return num_string;
  }

  public static void main(String[] args) {
    int[] array = input();
    BubbleSort.sort(array);
    output(array);
  }
}
