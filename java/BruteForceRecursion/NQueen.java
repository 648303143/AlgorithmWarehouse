package BruteForceRecursion;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * n皇后问题
 *
 * @author zhangqingyang
 * @date 2022-06-06-11:17
 */
public class NQueen {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        System.out.println(nQueen.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(record, n, 0);
    }

    private int process1(int[] record, int n, int i) {
        if (i >= n) {
            return 1;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (valid(record, i, j)) {
                record[i] = j;
                count += process1(record, n, i + 1);
            }
        }
        return count;
    }

    private boolean valid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        int[] record = new int[n];
        List<List<String>> res = new ArrayList<>();
        process2(record, n, 0, res);
        return res;
    }

    private void process2(int[] record, int n, int i, List<List<String>> res) {
        if (i >= n) {
            ArrayList<String> method = new ArrayList<>();
            for (int j : record) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    stringBuilder.append(k == j ? "Q" : ".");
                }
                method.add(stringBuilder.toString());
            }
            res.add(method);
            return;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (valid(record, i, j)) {
                record[i] = j;
                process2(record, n, i + 1, res);
            }
        }

    }

}
