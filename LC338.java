/**
 * @author zhangqingyang02
 * @date 2022-04-12-19:52
 */

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 */
public class LC338 {
}
class Solution338 {

    //当前这个数的二进制表示中 1 的个数 = 二进制最后一个1变成0的那个数二进制表示中 1 的个数 + 1
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            res[i] = res[i & i-1] + 1;
        }
        return res;
    }

    //去掉最低位，偶数加0，奇数加1
//    public int[] countBits(int n) {
//        int[] res = new int[n+1];
//        for (int i = 0; i < n + 1; i++) {
//            res[i] = res[i >> 1] + (1&i);
//        }
//        return res;
//    }

    //去掉最高位
//    public int[] countBits(int n) {
//        int[] res = new int[n+1];
//        int highBit = 0;
//        res[0] = 0;
//        for (int i = 1; i < n + 1; i++) {
//            if ((i & i-1) == 0){
//                highBit = i;
//            }
//            res[i] = res[i-highBit] +1;
//        }
//        return res;
//    }


    //循环计数
//    public int[] countBits(int n) {
//        int[] res = new int[n+1];
//        for (int i = 0; i < n+1; i++) {
//            res[i] = countOnes(i);
//        }
//        return res;
//    }
//
//    private int countOnes(int i) {
//        int ones = 0;
//        while (i > 0){
//            //使二进制最后一个1变成0
//            i &= i-1;
//            ones++;
//        }
//        return ones;
//    }
}