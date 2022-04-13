import java.util.Arrays;

/**
 * @author zzzZqy
 * @create 2021-10-02 15:05
 */
/*
912. 排序数组
给你一个整数数组 nums，请你将该数组升序排列。
 */
public class LC912 {
    public static void main(String[] args) {
        //方法一:快速排序
        int[] nums = new int[]{5,2,3,1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void subSort(int[] nums , int start , int end){
        if (start < end){
            int point = nums[start];
            int low = start;
            int high = end + 1;
            while (true) {
                while (low < end && nums[++low] <= point) ;

                while (high > start && nums[--high] >= point) ;

                if (low < high) {
                    swap(nums, low, high);
                } else if (low >= high) {
                    break;
                }
            }
            swap(nums,start,high);

            subSort(nums,start,high);
            subSort(nums,low,end);
        }
    }
    public static void quickSort(int[] nums){
        subSort(nums,0,nums.length-1);
    }
}
