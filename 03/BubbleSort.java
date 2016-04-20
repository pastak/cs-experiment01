public class BubbleSort {
  public static void sort(int[] array) {
    int unsorted = array.length;
    int i, tmp;
    while (unsorted > 2) {
      i = 0;
      while (i+1 < unsorted) {
        if (array[i] > array[i+1]) {
          tmp = array[i];
          array[i] = array[i+1];
          array[i+1] = tmp;
        }
        i++;
      }
      unsorted--;
    }
  }
}
