import java.util.*;
import java.io.*;

public class MyListTest {

  public static void ArrayListFillbyString(ArrayList<Integer> list, String input) {
    list.clear();
    String[] splited_input = input.split(",");
    for (int i = 0; i < splited_input.length; i++) {
      list.add(validate(Integer.parseInt(splited_input[i])));
    }
  }

  public static int validate(int n) {
      if (n < 1 || n > 9999) throw new IllegalStateException("入力可能な値は自然数で1以上9999以下のみです");
      return n;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // 10個の自然数をキーボードから入力し，それらを入力順に先頭から並べたリストを作り，画面に表示する．
    String userInputListString;
    ArrayList<Integer> list = new ArrayList<Integer>();
    boolean userInputCheck = false;
    while(!userInputCheck) {
      System.out.print("自然数を10個`,`で区切って入力: ");
      userInputListString = scan.next();
      try {
        ArrayListFillbyString(list, userInputListString);
        userInputCheck = true;
      } catch (IllegalStateException ex) {
        System.out.println("入力値が不正です: " + ex.getMessage());
      }
    }
    // 次の処理を10回繰り返す: 自然数をキーボードから入力する度に，それを insert した結果のリストを出力する．
    MyList.output(list);
    for (int i = 0; i < 10; i++) {
      System.out.print("\n 挿入する自然数を入力: ");
      try{
        MyList.insert(validate(Integer.parseInt(scan.next())), list);
        MyList.output(list);
      } catch (IllegalStateException ex) {
        System.out.println("入力値が不正です: " + ex.getMessage());
        i--;
      }
    }
    // 次の処理を10回繰り返す: 自然数をキーボードから入力する度に，それを delete した結果のリストを出力する．
    for (int i = 0; i < 10; i++) {
      System.out.print("\n 削除する自然数を入力: ");
      try {
        MyList.delete(validate(Integer.parseInt(scan.next())), list);
        MyList.output(list);
      } catch (IllegalStateException ex) {
        System.out.println("入力値が不正です: " + ex.getMessage());
        i--;
      }
    }
  }
}
