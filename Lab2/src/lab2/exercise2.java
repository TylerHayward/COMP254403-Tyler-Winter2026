package lab2;

import java.util.Random;

public class exercise2 {

  // Slow version — recomputes sum every time
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];

    for (int j = 0; j < n; j++) {
      double total = 0;

      for (int i = 0; i <= j; i++) {
        total += x[i];
      }

      a[j] = total / (j + 1);
    }

    return a;
  }

  // Fast version — uses running sum
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];
    double total = 0;

    for (int j = 0; j < n; j++) {
      total += x[j];
      a[j] = total / (j + 1);
    }

    return a;
  }

  // Create random array
  private static double[] randomArray(int n) {
    Random r = new Random();
    double[] x = new double[n];

    for (int i = 0; i < n; i++) {
      x[i] = r.nextDouble();
    }

    return x;
  }

  // Measure time
  private static long timeNanos(Runnable r) {
    long start = System.nanoTime();
    r.run();
    return System.nanoTime() - start;
  }

  public static void main(String[] args) {

    int[] sizes = {500, 1000, 2000, 4000, 8000};

    System.out.println("n\tprefixAverage1(ms)\tprefixAverage2(ms)");

    for (int n : sizes) {
      double[] x = randomArray(n);

      long t1 = timeNanos(() -> prefixAverage1(x));
      long t2 = timeNanos(() -> prefixAverage2(x));

      System.out.printf("%d\t%.3f\t\t\t%.3f%n",
              n, t1 / 1_000_000.0, t2 / 1_000_000.0);
    }
  }
}
