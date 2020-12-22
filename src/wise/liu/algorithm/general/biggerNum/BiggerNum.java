package wise.liu.algorithm.general.biggerNum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 输出比当前数4312更大的数 如：4321
 * 1234 1243 1324 1342
 * 1423 1432 2134 2143
 * 2314 2341 2413 2431
 * 3124 3142 3241 3214
 * 3412 3421 4123 4132
 * 4213 4231 4312 4321
 * 一、全排列后排序：找到比当前数大的第一个
 * 全排列公式 : f(n) = n! => f(4) = 1 x 2 x 3 x 4 = 24
 *
 * 二、 从后往前比较相连两数 如果前一个数比后一小交换 if最后两位直接返回
 *                  else  交换数后面所有数从小到大排序
 * @author wise liu
 * @date 2020/12/18
 */
public class BiggerNum {



    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        int[] text = { 4, 2, 3, 1 };
        System.out.println(fullPermutation(text));
        System.out.println(swapSulation(text));
    }

    public static Integer swapSulation(int[] a){
        for(int i=a.length-1; i>0; i--){
            boolean swap = false;
            if (a[i] > a[i-1]){
                int t = a[i];
                a[i] = a[i-1];
                a[i-1] = t;
                swap = true;
            }
            if (swap){
                if (i < a.length -1) {
                    Arrays.sort(a, i, a.length );
                }
                return getNumByArray(a);
            }

        }
        return null;
    }

    /**
     * 全排列后 排序 找到当前值 找到比当前数大的第一个
     * @param a
     * @return
     */
    public static Integer fullPermutation(int[] a){
        int f = getNumByArray(a);
        permutation(a, 0, a.length);
        list.sort(Comparator.naturalOrder());
        int i = list.indexOf(f);
        if (i <= list.size()-2){
            return list.get(i+1);
        }
        return null;
    }

    /**
     * 全排列输出
     *
     * @param a 要输出的整数数组
     * @param m 输出字符数组的起始位置
     * @param n 输出字符数组的长度
     */
    public static void permutation(int[] a, int m, int n) {
        int i;
        int t;
        if (m < n - 1) {
            permutation(a, m + 1, n);
            for (i = m + 1; i < n; i++) {
                t = a[m];
                a[m] = a[i];
                a[i] = t;
                permutation(a, m + 1, n);
                t = a[m];
                a[m] = a[i];
                a[i] = t;
            }
        } else {

            int c = getNumByArray(a);
            list.add(c);
        }
    }

    private static int getNumByArray(int[] a) {
        int x = a.length - 1;
        int c = 0;
        for(int i=0; i< a.length; i++){
            c += a[i] * Math.pow(10, x);
            x--;
        }
       return c;
    }

}
