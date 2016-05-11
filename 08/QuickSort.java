import java.util.*;
import java.io.*;

public class QuickSort {
  public static int choosePivot(int[] array, int i, int j) {
    // 中央値っぽいのをピボットにする
    int[] res = new int[2]; // [value, 中央との近さ]
    res[1] = j - i;
    int p = i; int center = (j - i) / 2;
    // 小さい値が半分くらいあればそれをピボットということにする
    while (p < j) {
      int t = array[p];
      int c = 0, l = 0;
      for (l = i; t < array[l]; c++) l++;
      if (res[1] > Math.abs(center - c)) {
        res[0] = array[l];
        res[1] = Math.abs(center - c);
      }
      p++;
    }
    return res[0];
  }

  private static void qsort(int[] array, int startPosition, int lastPosition) {
    if (lastPosition > startPosition) {
      int i = startPosition;
      int j = lastPosition;
      // ピボットを適当に選ぶ
      int pivot = choosePivot(array, i, j);
      int tmp = 0;
      while (true) {
        // ピボットより大きい値を先頭より順に探す
        while (array[i] < pivot) i++;
        // ピボットより小さい値を末尾から探す
        while (array[j] > pivot) j--;
        // この時、見つけた値の位置がj < iになっていれば、全てを舐め終わっているはずなので抜ける
        if (i >= j) break;
        // 見つけた2つの値を入れ替える
        tmp = array[i]; array[i] = array[j]; array[j] = tmp;
        // 次に1つずつ進める
        i++; j--;
      }
      qsort(array, startPosition, i - 1);
      qsort(array, j + 1, lastPosition);
    }
  }

  public static void sort(int[] array) {
    qsort(array, 0, array.length - 1);
  }
}
