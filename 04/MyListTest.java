import java.util.*;
import java.io.*;

public class MyListTest {

  public static ArrayList<Integer> ArrayListfromString(String input) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    String[] splited_input = input.split(",");
    for (int i = 0; i < splited_input.length; i++) {
      list.add(Integer.parseInt(splited_input[i]));
    }
    return list;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // 10個の自然数をキーボードから入力し，それらを入力順に先頭から並べたリストを作り，画面に表示する．
    System.out.print("自然数を10個`,`で区切って入力: ");
    String userIntputListString = scan.next();
    ArrayList<Integer> list = ArrayListfromString(userIntputListString);
    // 次の処理を10回繰り返す: 自然数をキーボードから入力する度に，それを insert した結果のリストを出力する．
    MyList.output(list);
    for (int i = 0; i < 10; i++) {
      System.out.print("\n 挿入する自然数を入力: ");
      MyList.insert(Integer.parseInt(scan.next()), list);
      MyList.output(list);
    }
    // 次の処理を10回繰り返す: 自然数をキーボードから入力する度に，それを delete した結果のリストを出力する．
    for (int i = 0; i < 10; i++) {
      System.out.print("\n 削除する自然数を入力: ");
      MyList.delete(Integer.parseInt(scan.next()), list);
      MyList.output(list);
    }
  }
}
