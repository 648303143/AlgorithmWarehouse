package LeetCode;

import com.sun.tools.corba.se.idl.constExpr.BooleanOr;
import org.junit.Test;

/**
 * @author zhangqingyang
 * @date 2022-07-05-19:28
 */
public class LC79 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean exist = solution79.exist(chars, word);
        System.out.println(exist);
    }
}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = process(board, word, i, j, 0, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean process(char[][] board, String word, int x, int y, int cur, boolean[][] visited) {
        if (board[x][y] != word.charAt(cur)){
            return false;
        }
        if (cur == word.length()-1) {
            return true;
        }

        visited[x][y] = true;
        int[][] path = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        boolean result = false;
        for (int[] choose : path) {
            int newX = x+choose[0];
            int newY = y + choose[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if (!visited[newX][newY]){
                    boolean flag = process(board,word,newX, newY,cur+1,visited);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[x][y] = false;
        return result;
    }
}
