package wise.liu.algorithm.general.reconstructqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

 注意：
 总人数少于1100人。

 示例

 输入:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 输出:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height

 * @author wise liu
 * @date 2020/11/16
 */
public class ReconstructQueueSolution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] a : people){
            list.add(a[1], a);
        }
        return list.toArray(new int[list.size()][2]);
    }


    public static void main(String[] args) {
        ReconstructQueueSolution solution = new ReconstructQueueSolution();
        String strListInput = "[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]";
        strListInput = strListInput.replaceAll("\\[", "").replaceAll("]", "");
        long startTime = System.currentTimeMillis();
        List<String> list = Arrays.asList(strListInput.split(","));
        int[] nums = list.stream().mapToInt(Integer::parseInt).toArray();
        int[][] array = new int[6][2];
        for(int i=0;i<6;i++){
            for (int j=0;j<2;j++){
                array[i][j] = nums[i*2+j];
            }
        }
        int[][] r = solution.reconstructQueue(array);
        System.out.println(Arrays.deepToString(r));
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
