package wise.liu.algorithm.general.majority;

import java.util.*;

/**
 * 169. 多数元素(众数)
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2

 链接：https://leetcode-cn.com/problems/majority-element
 * @author wise liu
 * @date 2020/11/27
 */
public class MajorityElementSolution {

    /**
     * 用Map计数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }else {
                map.put(nums[i], 1);
            }
        }
        Map.Entry<Integer,Integer>  maxCount =  null;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (maxCount == null || entry.getValue() > maxCount.getValue()){
                maxCount = entry;
            }
        }
        return maxCount.getKey();
    }

    /**
     * 如果有出现次数大于 ⌊ n/2 ⌋ 的众数， 排序后n/2一定是
     * @param nums
     * @return
     */
    public int majorityElement0(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2 ];
    }

    /**
     * 用优先队列排序 如果有出现次数大于 ⌊ n/2 ⌋ 的众数， 排序后n/2一定是
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int len = (nums.length + 1) >> 1;
        //大顶堆
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(len, Comparator.comparingInt(item -> -item));
        for (int num : nums) {
            pQueue.offer(num);
            if (pQueue.size() > len) {
                pQueue.poll();
            }
        }
        return pQueue.poll();
    }

    /**
     * 摩尔投票法
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     当票数count为0时，更换候选人，并将票数count重置为1。
     遍历完数组后，cand_num即为最终答案。

     为何这行得通呢？
     投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    public static void main(String[] args) {
        String arrString = "[1,1,2,1,3]";
        String[] arr = arrString.replace("[", "").replace("]", "").split(",");
        int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        MajorityElementSolution solution = new MajorityElementSolution();
        int mar = solution.majorityElement1(nums);
        System.out.println(mar);
    }
}
