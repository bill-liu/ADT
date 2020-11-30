package wise.liu.datastructure.collection.list.exercises;

import wise.liu.datastructure.collection.list.ListNode;

import java.util.Arrays;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * @author wise liu
 * @date 2020/11/24
 */
public class ReverseListSolution {
    /**
     * 思路：定义一个pre cur指针 先用临时节点保存cur.next 然后执行交换逻辑就行
     * @param head
     * @return
     */
    public ListNode reverseList0(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null,cur = head;
        while(cur.next != null){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        cur.next = pre;
        return cur;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null,cur = head;
        return reverse(pre, cur);
    }

    public ListNode reverse(ListNode pre, ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode t = cur.next;
        cur.next = pre;
        pre = cur;
        cur = t;
        return reverse(pre, cur);
    }

    public static void main(String[] args) {
        String listStr = "[1,2,3,4,5,6]";
        listStr = listStr.replace("[", "").replace("]", "").replace(" ", "");
        String[] arr = listStr.split(",");
        int[] a = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i=1; i<a.length;i++){
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        ReverseListSolution solution = new ReverseListSolution();
        ListNode h = solution.reverseList(head);
        ListNode c = h;
        while (c != null){
            System.out.print(c.val + ",");
            c = c.next;
        }
    }
}
