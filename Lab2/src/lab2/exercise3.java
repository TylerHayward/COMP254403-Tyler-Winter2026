package lab2;

import java.util.Arrays;
import java.util.Random;

public class exercise3 {

  // unique1: checks every pair (slow)
  public static boolean unique1(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++)
        if (a[i] == a[j]) return false;
    return true;
  }

  // unique2: sort then check neighbors (faster)
  public static boolean unique2(int[] a) {
    int[] b = Arrays.copyOf(a, a.length);
    Arrays.sort(b);
    for (int i = 1; i < b.length; i++)
      if (b[i] == b[i - 1]) return false;
    return true;
  }

  // make random int array
  private static int[] randomIntArray(int n) {
    Random r = new Random();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = r.nextInt();
    return a;
  }

  // measure runtime
  private static long timeNanos(Runnable r) {
    long start = System.nanoTime();
    r.run();
    return System.nanoTime() - start;
  }

  // check if algorithm finishes within time limit
  private static boolean runsWithin(int n, long limitNanos, boolean useUnique2) {
    int[] a = randomIntArray(n);
    long t = timeNanos(() -> {
      if (useUnique2) unique2(a);
      else unique1(a);
    });
    return t <= limitNanos;
  }

  // find max n using "doubling + binary search"
  private static int findMaxN(long limitNanos, boolean useUnique2) {

    // 1) Find a range: lowGood works, highBad fails
    int lowGood = 1;
    int highBad = 1;

    while (runsWithin(highBad, limitNanos, useUnique2)) {
      lowGood = highBad;
      highBad *= 2;                 // keep doubling until it becomes too slow
      if (highBad > 50_000_000) break; // safety cap
    }

    // 2) Binary search between lowGood and highBad
    int left = lowGood;
    int right = highBad;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (runsWithin(mid, limitNanos, useUnique2)) {
        left = mid;   // mid works, try bigger
      } else {
        right = mid;  // mid fails, try smaller
      }
    }

    return left; // largest confirmed size that still works
  }

  public static void main(String[] args) {
    long oneMinute = 60L * 1_000_000_000L;

    System.out.println("Finding max n for unique1 (<= 60 seconds)...");
    int max1 = findMaxN(oneMinute, false);
    System.out.println("Max n unique1: " + max1);

    System.out.println("Finding max n for unique2 (<= 60 seconds)...");
    int max2 = findMaxN(oneMinute, true);
    System.out.println("Max n unique2: " + max2);
  }
}
