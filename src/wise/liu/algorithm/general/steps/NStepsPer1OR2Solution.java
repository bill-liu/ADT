package wise.liu.algorithm.general.steps;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬台阶问题
 * f(n) = f(n-1) + f(n-2)
 */
public class NStepsPer1OR2Solution {

    /**
     * 递归带缓存
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int step(int n){
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        Integer val = map.get(n);
        if (val != null){
            return val;
        }
        val = step(n-1) + step(n-2);
        map.put(n, val);
        return val;
    }

    /**
     * 单纯递归
     * @param n
     * @return
     */
    public int stepBase(int n){
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }

        return stepBase(n-1) + stepBase(n-2);
    }

    /**
     * 循环 等于前两节台阶的走法相加
     * @param n
     * @return
     */
    public int climbStairs(int n){
        int l = 1, c = 2;
        if (n==1){
            return l;
        }
        if (n==2){
            return c;
        }
        int r  = 3;
        for(int i = 3; i<n; i++){
            l = c;
            c = r;
            r = l + c;

        }
        return r;
    }


    public static void main(String[] args) {
        NStepsPer1OR2Solution solution = new NStepsPer1OR2Solution();
        long start  = System.currentTimeMillis();
        System.out.println(solution.step(45));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start);
        System.out.println(solution.climbStairs(45));
        System.out.println(System.currentTimeMillis() - end1);

        long end2 = System.currentTimeMillis();
        System.out.println(solution.stepBase(45));
        System.out.println(System.currentTimeMillis() - end2);
    }
}
