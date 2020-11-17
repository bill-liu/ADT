package wise.liu.algorithm.general.maxnum;

/**239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

 进阶：

 你能在线性时间复杂度内解决此题吗？

 示例:
 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7 

 提示：
 1 <= nums.length <= 10^5
 -10^4 <= nums[i] <= 10^4
 1 <= k <= nums.length

 链接：https://leetcode-cn.com/problems/sliding-window-maximum

 * @author wise liu
 * @date 2020/11/17
 */
public class MaxSlidingWindowSolution {

    //暴力求解 接近O(N^2)
    public int[] maxSlidingWindow0(int[] nums, int k) {
        if(k < 0 || nums == null && nums.length == 0){
            return new int[0];
        }
        if (k==1 || nums.length<k){
            return nums;
        }
        int[] result = new int[nums.length-k+1];
        int l = 0;
        int r = k;
        while (r<=nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = l; i < r; i++) {
                if (nums[i]>max){
                    max = nums[i];
                }
            }
            result[l] = max;
            l++;
            r++;
        }
        return result;
    }

    //
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k < 0 || nums == null && nums.length == 0){
            return new int[0];
        }
        if (k==1 || nums.length<k){
            return nums;
        }
        int[] result = new int[nums.length-k+1];
        int l = 0;
        int r = k;
        while (r<=nums.length) {
            int max = Integer.MIN_VALUE;

            result[l] = max;
            l++;
            r++;
        }
        return result;
    }

}
