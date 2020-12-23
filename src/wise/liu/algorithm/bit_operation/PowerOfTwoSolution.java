package wise.liu.algorithm.bit_operation;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 示例 3:

 输入: 218
 输出: false

 链接：https://leetcode-cn.com/problems/power-of-two
 * @author wise liu
 * @date 2020/12/22
 */
public class PowerOfTwoSolution {

    /**
     * 最简单的求余数方案 余数为0 就一直除以2  直到余数部位0  是2的幂的话 最后为1 时间复杂度为 O(logN)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo0(int n){
        if (n<=0){
            return false;
        }
        while (n%2 == 0){
            n /= 2;
        }
        return n==1;
    }

    /**
     * 保留最后一位1 -x&x=x
     * 负数用补码表示 -x = ~x+1 (取反+1)
     * -x和x 有一个特点最后一个1的位置都相同 前面其他位都相反
     * so -x&x能得到最后一个1
     * 如果是2的幂 只有一个1 so -x&x=x
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n){
        if (n<=0){
            return false;
        }
        return (n&-n)==n;
    }

    /**
     * x&(x-1)去除二进制最右边的1
     * 如果是2的幂 只有一个1 so x&(x-1)=0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n){
        if (n<=0){
            return false;
        }
        return (n&(n-1))==0;
    }
}
