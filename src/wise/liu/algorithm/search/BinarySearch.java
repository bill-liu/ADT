package wise.liu.algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuyingming
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int find, int min, int max){
        if (array == null || array.length == 0){
            return -1;
        }
        if (min > max){
            return -1;
        }
        int mid = (min + max)/2;
        if (array[mid] == find){
            return mid;
        }

        if (array[mid] > find){
            return binarySearch(array, find, min, mid-1);
        }

        return binarySearch(array, find, mid + 1, max);
    }

    public static int binarySearch(int[] array, int find){
        int l = 0;
        int r = array.length - 1;

        while (l <= r){
            int mid = (l + r)/2;
            if (array[mid] == find){
                return mid;
            }
            if (array[mid] > find){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static List<Integer> binarySearchAll(int[] array, int find){
        int l = 0;
        int r = array.length - 1;
        while (l <= r){
            int mid = (l + r)/2;
            if (array[mid] == find){
                return getSameValueIndexs(array, find, mid);
            }
            if (array[mid] > find){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return Collections.emptyList();
    }

    public static List<Integer> binarySearchAll(int[] array, int find, int min, int max){
        if (array == null || array.length == 0){
            return null;
        }
        if (min > max){
            return null;
        }
        int mid = (min + max)/2;
        if (array[mid] == find){
            return getSameValueIndexs(array, find, mid);
        }

        if (array[mid] > find){
            return binarySearchAll(array, find, min, mid-1);
        }

        return binarySearchAll(array, find, mid + 1, max);
    }

    private static List<Integer> getSameValueIndexs(int[] array, int find, int mid) {
        List<Integer> result = new ArrayList<>();
        result.add(mid);
        int left = mid - 1;
        while (left >= 0 && array[left] == find){
            if (left < 0){
                break;
            }
            result.add(left);
            left--;
        }
        int right = mid + 1;
        while (right < array.length  && array[right] == find){
            if (right > array.length -1){
                break;
            }
            result.add(right);
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 7, 9, 10};
        int index = binarySearch(array, 10, 0, array.length-1);
        int index1 = binarySearch(array, 5);

        System.out.println(index + " " + index1);

        List<Integer> index2 = binarySearchAll(array, 5, 0, array.length-1);
        List<Integer> index3 = binarySearchAll(array, 5);
        System.out.println(index2 + " " + index3);
    }
}
