package LeetCode; /**
 * @author zzzZqy
 * @create 2021-09-29 17:55
 */
/**
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LC53 {
// 1.假如全是负数，那就是找最大值即可，因为负数肯定越加越小。
// 2.如果有正数，则肯定从正数开始计算和，不然前面有负值，和肯定变小了，所以从正数开始。
// 3.当和小于零时，这个区间就告一段落了，然后从下一个正数重新开始计算(也就是又回到2了)。而 dp 也就体现在这个地方。
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //之前区间和
        int presum = 0;
        //最大和
        int maxsum = nums[0];

        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //如果之前区间和大于0,可以看做是一个正数,继续向后累加
            if (presum>0){
                //将当前数加入区间
                presum += nums[i];
                //如果之前区间和小于等于0,可以看做是一个负数(等于0相当于无影响),丢弃此区间
            }else{
                //把当前数加入区间
                presum = nums[i];
            }
            maxsum = Math.max(presum,maxsum);
        }
        System.out.println(maxsum);
    }
}
