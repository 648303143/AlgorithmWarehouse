package BruteForceRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqingyang
 * @date 2022-06-02-17:02
 */
public class Hanoi {

    public static void main(String[] args) throws IOException {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(0);
        Hanoi hanoi = new Hanoi();
        hanoi.hanota(A,new ArrayList<>(),new ArrayList<>());
    }
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n,A,B,C);
    }

    public void move(int index, List<Integer> from, List<Integer> other, List<Integer> to) {
        if (index == 1) {
            to.add(from.remove(from.size()-1));
            return;
        }
        move(index-1, from, to, other);
        to.add(from.remove(from.size()-1));
        move(index-1, other, from, to);
    }

}
