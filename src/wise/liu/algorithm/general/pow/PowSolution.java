package wise.liu.algorithm.general.pow;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

 示例 1:

 输入: 2.00000, 10
 输出: 1024.00000
 示例 2:

 输入: 2.10000, 3
 输出: 9.26100
 示例 3:

 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25
 说明:

 -100.0 < x < 100.0
 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

 链接：https://leetcode-cn.com/problems/powx-n
 * @author wise liu
 * @date 2020/11/26
 */
public class PowSolution {
    /**
     * 暴力求解
     * @param x
     * @param n
     * @return
     */
    public double myPow0(double x, int n) {
        double pow = 1;
        for(int i = 0; i < n; i++){
            pow = pow * x;
        }
        return pow;
    }

    /**
     * 递归求解O(n)
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (n==0){
            return 1;
        }
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        if (n%2==0){
            return myPow1(x, n/2) * myPow1(x, n/2);
        }
        return x * myPow1(x, n/2) * myPow1(x, n/2);
    }

    /**
     * 快速幂法 可将时间复杂度降低至 O(logn) 2^2 = 2^(0*2^0) * 2^(1*2^1)
     * n & 1(与操作）： 判断 n 二进制最右一位是否为 1 ；
     * n>>1 （移位操作）： n 右移一位（可理解为删除最后一位）
     * Java 代码中 int32 变量 n∈[−2147483648,2147483647] ，
     * 因此当 n = -2147483648 时执行 n = -n会因越界而赋值出错。
     * 解决方法是先将 nn 存入 long 变量 b ，后面用 b 操作即可
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n==0){
            return 1;
        }
        long b = n;
        if (b < 0){
            x = 1/x;
            b = -b;
        }
        double pow = 1;
        while (b > 0){
            if((b&1)==1){
                pow = pow * x;
            }
            x = x*x;
            b = b >> 1;
        }
       return pow;
    }

    public static void main(String[] args) {
        PowSolution powSolution = new PowSolution();
        long start = System.currentTimeMillis();
        System.out.println(powSolution.myPow0(0.00001, 2147483647));
        long start1 = System.currentTimeMillis();
        System.out.println(start1-start);
        System.out.println(powSolution.myPow1(0.00001, 2147483647));
        long start2 = System.currentTimeMillis();
        System.out.println(start2-start1);

        System.out.println(powSolution.myPow2(0.00001, 2147483647));
        System.out.println(System.currentTimeMillis()-start2);
    }
}
