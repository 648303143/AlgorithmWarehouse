package sort;

import java.util.Arrays;

/**
 * @author zhangqingyang02
 * @date 2022-04-29-15:27
 */
public class Checker {

    /**
     * 正确的排序方法
     */
    public static void rightSort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 生成一个随机大小，最大数随机的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxNum) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum + 1)) - (int) (Math.random() * maxNum);
        }
        return arr;
    }

    /**
     * 复制当前数组的一个样本
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    /**
     * 判断两个数组是否完全相同
     */
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr2 == null || arr1 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void check(ISort method) {
        //测试次数
        int testTims = 10000;
        //最大测试容量
        int maxSize = 20;
        //最大测试数据
        int maxNum = 20;
        boolean euqals = true;
        for (int i = 0; i < testTims; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxNum);
            int[] arr2 = copyArray(arr1);
            //用自己的算法排序
            method.sort(arr1);
            //用java.util.Arrays包的排序算法排序
            rightSort(arr2);
                //比较是否相同
            if (!isEquals(arr1, arr2)) {
                //一旦有不一样的值就设为false;
                euqals = false;
                break;
            }
        }
        //没错就恭喜，有错就报错
        System.out.println(euqals ? "Success:恭喜你！没毛病！" : "Error：抱歉，有错误");
        int[] newArr = generateRandomArray(maxSize, maxNum);
        //没排序的数组打印出来
        printArray(newArr);
        //排序后
        method.sort(newArr);
        //再次打印，程序员自己看看有没有毛病
        printArray(newArr);
    }
}
