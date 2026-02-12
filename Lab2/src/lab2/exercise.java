package lab2;

public class exercise {


  // Big-O: O(n)
  // This method sums all elements of the array.
  // The loop runs n times and does constant work each iteration.
  // Therefore runtime grows linearly → O(n).
  public static int example1(int[] arr) {
    int n = arr.length, total = 0;
    for (int j = 0; j < n; j++)
      total += arr[j];
    return total;
  }

  // Big-O: O(n)
  // This method sums elements at even indices.
  // Loop runs about n/2 times, which is still linear.
  // Big-O ignores constants → O(n).
  public static int example2(int[] arr) {
    int n = arr.length, total = 0;
    for (int j = 0; j < n; j += 2)
      total += arr[j];
    return total;
  }

  // Big-O: O(n^2)
  // Nested loop: outer runs n times, inner runs up to j.
  // Total work ≈ 1 + 2 + ... + n = n(n+1)/2 → quadratic growth.
  public static int example3(int[] arr) {
    int n = arr.length, total = 0;
    for (int j = 0; j < n; j++)
      for (int k = 0; k <= j; k++)
        total += arr[j];
    return total;
  }

  // Big-O: O(n)
  // Uses running prefix sum instead of recomputing.
  // Single loop → linear time.
  public static int example4(int[] arr) {
    int n = arr.length, prefix = 0, total = 0;
    for (int j = 0; j < n; j++) {
      prefix += arr[j];
      total += prefix;
    }
    return total;
  }

  // Big-O: O(n^3)
  // Three levels of computation:
  // Outer loop n times.
  // Nested loops produce quadratic work inside.
  // n * n^2 = n^3 → cubic time.
  public static int example5(int[] first, int[] second) {
    int n = first.length, count = 0;
    for (int i = 0; i < n; i++) {
      int total = 0;
      for (int j = 0; j < n; j++)
        for (int k = 0; k <= j; k++)
          total += first[k];
      if (second[i] == total) count++;
    }
    return count;
  }
}
