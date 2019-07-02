/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int trials;
    private int n;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new java.lang.IllegalArgumentException("N is out of bounds");
        if (trials <= 0) throw new java.lang.IllegalArgumentException("T is out of bounds");

        this.trials = trials;
        this.thresholds = new double[trials];
        this.n = n;
        for (int i = 0; i < trials; i++) {
            thresholds[i] = getPercolationThreshold();
        }
    }

    public double getPercolationThreshold() {
        Percolation perc = new Percolation(n);

        int randCol;
        int randRow;
        int count = 0;
        while (!perc.percolates()) {
            do {
                randRow = StdRandom.uniform(1, n + 1);
                randCol = StdRandom.uniform(1, n + 1);
            } while (perc.isOpen(randRow, randCol));
            count++;
            perc.open(randRow, randCol);
        }
        return count / Math.pow(n, 2);
    }


    // sample
    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        if (trials == 1) return Double.NaN;
        return StdStats.stddev(thresholds);
    }

    // high endpoint of 95 %confidence interval
    public double confidenceHi() {
        double confidenceLevel = 1.96;
        double temp = confidenceLevel * stddev() / Math.sqrt(trials);
        return mean() + temp;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double confidenceLevel = 1.96;
        double temp = confidenceLevel * stddev() / Math.sqrt(trials);
        return mean() - temp;
    }

    private static void printArray(double[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
    }

    // test client
    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]),
                                                      Integer.parseInt(args[1]));
        System.out.println("mean = " + stats.mean());
        System.out.println("stddev = " + stats.stddev());
        System.out.printf("95%% confidence interval = [%f, %f]",
                          stats.confidenceLo(), stats.confidenceHi());

    }
}
