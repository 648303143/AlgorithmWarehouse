package LeetCode; /**
 * @author zhangqingyang02
 * @date 2022-04-15-20:27
 */

/**
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class LC461 {
}


class Solution461 {

    //还可以使用java内置函数
//    public int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);
//    }


    public int hammingDistance(int x, int y) {
        int count = 0;
        int z = x ^ y;
        while (z>0) {
            //z & （z-1） 可以把z的最右面的一个1变成0
            //LC338题也用到了这个方法，在处理位运算的题中可能会很有用
            z = z & (z-1);
            count++;
        }
        return count;
    }

//    public int hammingDistance(int x, int y) {
//        int count = 0;
//        int z = x ^ y;
//        while (z>0) {
//            if ((z & 1) == 1){
//                count++;
//            }
//            z = z >> 1;
//        }
//        return count;
//    }
}