import java.util.Arrays;

/**
 * @author zzzZqy
 * @create 2021-10-01 17:26
 */
/*
88. 合并两个有序数组
给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 */
public class LC88 {
    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        solution88.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //方法一:
//        for(int i = 0 ; i < n ; i++ ){//先合并
//            nums1[i+m] =nums2[i] ;
//        }
//
////        for(int i = 0 ; i < nums1.length ; i++){//再排序
////            for(int j = 0 ; j < nums1.length -1 -i ; j++){
////                if(nums1[j] > nums1[j+1]){
////                    int temp = nums1[j];
////                    nums1[j] = nums1[j+1];
////                    nums1[j+1] = temp;
////                }
////            }
////        }
//        Arrays.sort(nums1);

        //方法二:
        //利用数组nums1与nums2已经被排序的性质，我们可以使用双指针方法。
        //这一方法将两个数组看作队列，每次从两个数组头部取出比较小的数字放到结果中。

        int[] queue = new int[m +n];
        int p1 = 0,p2 = 0;//声明指针

        for (int i = 0; i < queue.length; i++) {
            if (p1 != m && p2 !=n){
                if (nums1[p1] <= nums2[p2]){
                    queue[i] = nums1[p1];
                    p1++;
                }else{
                    queue[i] = nums2[p2];
                    p2++;
                }
            }else if(p1 == m){
                queue[i] = nums2[p2];
                p2++;
            }else if(p2 == n){
                queue[i] = nums1[p1];
                p1++;
            }

        }
        for (int i = 0; i < queue.length; i++) {
            nums1[i] = queue[i];
        }

    }
}