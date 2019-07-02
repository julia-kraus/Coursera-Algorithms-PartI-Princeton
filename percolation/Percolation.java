/* *****************************************************************************
 *  Name: Julia Kraus
 *  Date: 7/1/2019
 *  Description: Solution to Percolation Assignment
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int size;
    private WeightedQuickUnionUF uf;
    private boolean[] sitesOpen;

    // create n-by-n grid with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n should be greater than zero");
        }
        this.n = n;
        this.size = n * n;

        this.sitesOpen = new boolean[this.size];

        // weighted quick union containing also virtual top/bottom site
        uf = new WeightedQuickUnionUF(this.size + 2);

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {

        int index = getIndex(row, col);
        sitesOpen[index] = true;
        connectOpenNeighbors(row, col);
    }


    public void connectOpenNeighbors(int row, int col) {
        int index = getIndex(row, col);

        if (row == 1) {
            union(index, 0);
        }
        if (row == n) {
            union(index, this.size + 1);
        }

        // connect top site if it is open
        connectNeighbor(index, row - 1, col);
        // connect bottom site if it is open
        connectNeighbor(index, row + 1, col);
        // connect left site if it is open
        connectNeighbor(index, row, col - 1);
        // connect right site if it is open
        connectNeighbor(index, row, col + 1);
    }


    public void connectNeighbor(int idxFrom, int rowTo, int colTo) {
        if (isSite(rowTo, colTo) && isOpen(rowTo, colTo)) {
            int idxTo = getIndex(rowTo, colTo);
            union(idxFrom, idxTo);
        }
    }

    public void union(int index, int indexNeighbor) {
        this.uf.union(index, indexNeighbor);
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = getIndex(row, col);
        return sitesOpen[index];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return uf.connected(0, getIndex(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        int sum = 0;
        for (boolean b : sitesOpen) {
            sum += b ? 1 : 0;
        }
        return sum;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(0, size + 1);
    }

    // gets a site's index in sitesOpen array from its row and col

    public int getIndex(int row, int col) {
        int index = (row - 1) * n + col - 1;
        return index;
    }

    public boolean isSite(int row, int col) {
        if (row <= 0 || row > n) {
            return false;
        }
        if (col <= 0 || col > n) {
            return false;
        }

        return true;

    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
