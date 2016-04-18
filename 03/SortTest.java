import java.util.*;
import java.io.*;

public class SortTest {
  public static int inputNumberCount;

  public static int[] read() {
    // 標準入力からの入力ファイル名を受け取り，入力ファイル内のソート対象データを配列に格納し，得られた配列を返す．
    Scanner scan = new Scanner(System.in);
    System.out.print("Type your input file name: ");
    String intputFileName = scan.next();
    int[] numbers = new int [50];
    try {
      File inputFile = new File(intputFileName);
      Scanner sc = new Scanner(inputFile);
      int i = 0;
      while (sc.hasNext()) {
        int num = sc.nextInt();
        numbers[i++] = num;
      }
      inputNumberCount = i;
    } catch (FileNotFoundException ex) {
      System.out.println("Filename: " + intputFileName + "is not found");
      return null;
    }
    return numbers;
  }
  public static void output(int[] sorted) {
    // ソートされたデータを画面に出力する．
    int counter = 1;
    for (int num : sorted) {
      if (num == 0) continue;
      System.out.print(rightJustify(num));
      if (counter % 10 == 0) {
        System.out.print("\n");
      } else if (counter != inputNumberCount){
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
    BubbleSort bsort = new BubbleSort();
    int[] input = read();
    int[] sorted = bsort.sort(input);
    output(sorted);
  }
}
