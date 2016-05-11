import java.util.*;
import java.io.*;

public class QuickSort {
  public static int choosePivot(int[] array, int i, int j) {
    // とりあえず何も考えずに先頭を返す
    return i;
  }

  private static void qsort(int[] array, int startPosition, int lastPosition) {
    if (lastPosition > startPosition) {
      int i = startPosition;
      int j = lastPosition;
      // ピボットを適当に選ぶ
      int pivot = array[choosePivot(array, i, j)];
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
