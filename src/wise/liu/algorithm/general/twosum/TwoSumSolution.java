package wise.liu.algorithm.general.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 * @author wise liu
 * @date 2020/11/15
 */
public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //O(n^2)
        for(int i=0;i<nums.length;i++){
//            for(int j = 0; j<nums.length; j++){
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            int find = target - nums[i];
            Integer r = map.get(find);
            if(r != null && i!=r){
                return new int[]{i,r};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        String strListInput = "[2,7,11,15]";
        strListInput = strListInput.replace("[", "").replace("]", "");
        long startTime = System.currentTimeMillis();
        List<String> list = Arrays.asList(strListInput.split(","));
        int[] nums = list.stream().mapToInt(Integer::parseInt).toArray();

        int[] r = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(r));
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
