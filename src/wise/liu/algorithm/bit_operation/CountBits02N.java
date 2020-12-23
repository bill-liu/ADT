package wise.liu.algorithm.bit_operation;

/**
 * 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

 示例 1:

 输入: 2
 输出: [0,1,1]
 示例 2:

 输入: 5
 输出: [0,1,1,2,1,2]
 进阶:

 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 要求算法的空间复杂度为O(n)。
 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

 链接：https://leetcode-cn.com/problems/counting-bits
 * @author wise liu
 * @date 2020/12/23
 */
public class CountBits02N {
    /**
     * 方法一：暴力求解 遍历每一个数字求出二进制1的个数
     * 时间复杂度 : O(n*sumOfNum(bit 1))
     * @param num
     * @return
     */
    public int[] countBits0(int num) {
        int[] array  = new int[num+1];
        for(int i=1; i<=num; i++){
            int c = hammingWeight(i);
            array[i] = c;
        }
        return array;
    }

     public int hammingWeight(int n){
         int c = 0;
         while(n!=0){
             c++;
             n = n&(n-1);
         }
         return c;
     }

    /**
     * 时间复杂度 : O(n)
     * 方法二：i 与 i&(i-1)的二进制相差最后一个1
     * so array[i] = array[i&(i-1)] + 1;
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] array  = new int[num+1];
        for(int i=1; i<=num; i++){
            array[i] = array[i&(i-1)] + 1;
        }
        return array;
    }
}
