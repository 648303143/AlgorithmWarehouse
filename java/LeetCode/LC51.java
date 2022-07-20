package LeetCode;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-07-19-17:03
 */
public class LC51 {

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        System.out.println(lists);
    }
}


class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> record = new ArrayList<>(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }
        for (int i = 0; i < n; i++) {
            record.add(stringBuilder.toString());
        }

        backtrack(res, record, 0);
        return res;
    }


    private void backtrack(List<List<String>> res, List<String> record, int row) {
        if (row == record.size()) {
            res.add(new ArrayList<>(record));
            return;
        }

        for (int i = 0; i < record.get(row).length(); i++) {
            if (isValid(record, row, i)) {
                StringBuilder old = new StringBuilder(record.get(row));
                StringBuilder replace = new StringBuilder(record.get(row));
                replace.replace(i, i+1, "Q");
                record.set(row, replace.toString());
                backtrack(res, record, row + 1);
                record.set(row, old.toString());
            }
        }
    }

    private boolean isValid(List<String> record, int row, int col) {
        String thisRow = record.get(row);
        for (int i = 0; i < thisRow.length(); i++) {
            if ('Q' == (thisRow.charAt(i))) {
                return false;
            }
        }

        for (int i = 0; i < row; i++) {
            if ('Q' == (record.get(i).charAt(col))) {
                return false;
            }
        }

        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if ('Q'==(record.get(x).charAt(y))) {
                return false;
            }
        }

        for (int x = row, y = col; x >= 0 && y < record.get(0).length(); x--, y++) {
            if ('Q'==(record.get(x).charAt(y))) {
                return false;
            }
        }
        return true;
    }
}
