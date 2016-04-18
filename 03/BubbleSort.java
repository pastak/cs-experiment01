public class BubbleSort {
  public int[] sort(int[] input) {
    int unsorted = input.length;
    int i, tmp;
    while (unsorted > 2) {
      i = 0;
      while (i+1 < unsorted) {
        if (input[i] > input[i+1]) {
          tmp = input[i];
          input[i] = input[i+1];
          input[i+1] = tmp;
        }
        i++;
      }
      unsorted--;
    }
    return input;
  }
}
