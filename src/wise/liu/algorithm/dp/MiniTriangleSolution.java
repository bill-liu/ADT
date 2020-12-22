package wise.liu.algorithm.dp;

import java.util.*;

/**
 * @author wise liu
 * @date 2020/12/4
 */
public class MiniTriangleSolution {

    /**
     * 递归 f(i,j)=min(f(i+1,j),f(i+1,j+1))+triangle[i][j]
     * @return
     */
    public int minimumTotal0(List<List<Integer>> triangle){
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        return dfs(triangle, 0, 0);
    }

    public int dfs(List<List<Integer>> triangle, int i, int j){
        if (triangle.size() == i){
            return 0;
        }
        return Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
    }
    /**
     * 动态规划 方程: f(i,j) = triangle[i][j] + min(f(i+1，j), f(i+1,j+1))
     * + 状态压缩：覆盖之前层的最小值 只保留当前层的最小值 所以一维数组就可以
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        List<Integer> r = new ArrayList<>(triangle.get(triangle.size()-1));
        for(int i = triangle.size()-2; i>=0;i--){
            List<Integer> son = triangle.get(i);
            if(son == null || son.size() == 0){
                continue;
            }
            for(int j = 0; j<son.size();j++){
                r.set(j, son.get(j) + Math.min(r.get(j),r.get(j+1)));
            }

        }
        return r.get(0);
    }
}
