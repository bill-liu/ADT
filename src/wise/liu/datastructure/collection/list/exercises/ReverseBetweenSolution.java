package wise.liu.datastructure.collection.list.exercises;

import wise.liu.datastructure.collection.list.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL

 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * @author wise liu
 * @date 2020/11/22
 */
public class ReverseBetweenSolution {

    /**
     * 题目理解错了  不是交换m和n 而是反转m到n
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween0(ListNode head, int m, int n) {
        if(head == null || head.next == null || m>=n || m<=0){
            return head;
        }
        int i = 1;
        ListNode prem = null, pren = null, curm = null, curn = null;
        ListNode cur = head;
        while(cur != null){
            if(i == m-1){
                prem = cur;
            }else if(i == m){
                curm = cur;
            }
            if(i == n-1){
                pren = cur;
            }else if(i == n){
                curn = cur;
            }
            if (i >= n){
                break;
            }
            cur = cur.next;
            i++;
        }
        if(curm == null || curn == null){
            return head;
        }
        if(prem != null){
            prem.next = curn;
        }
        pren.next = curm;
        ListNode t = curm.next;
        curm.next = curn.next;
        curn.next = t;
        //如果和头结点 交换
        if ( m == 1){
            return curn;
        }
        return head;
    }

    public ListNode reverseBetween01(ListNode head, int m, int n) {
        if(head == null || head.next == null || m>=n || m<=0){
            return head;
        }
        int i = 1;
        ListNode pre = null, prem = null, curm = null;
        ListNode cur = head;

        while(cur != null){
            if(i == m-1){
                prem = cur;
                pre = prem;
            }else if(i == m){
                curm = cur;
            }
            if (i>=m && i<=n){
                ListNode t = cur.next;
                cur.next = pre;
                pre = cur;
                cur = t;
            }else if(i<m){
                cur = cur.next;
            }
            if (i >= n){
                break;
            }
            i++;
        }
        if(prem != null){
            prem.next = pre;
        }

        curm.next = cur;

        //如果和头结点 交换
        if ( m == 1){
            return pre;
        }
        return head;
    }

    // 不使用额外的空间
    // Time  Complexity: O(N)
    // Space Complexity: O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;

        int cnt = n - m;
        while (--m > 0) {
            p = p.next;
        }

        ListNode q = p.next, prev = q, cur = prev.next;
        // 反转链表的标准做法
        while (cnt-- > 0) {
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }

        p.next = prev;
        q.next = cur;

        return dummy.next;
    }

    // 辅助栈解法。使用了额外的空间
    // Time  Complexity: O(N)
    // Space Complexity: O(N)
    public ListNode reverseBetween1(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;

        int cnt = n - m + 1;
        while (--m > 0) {
            p = p.next;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode q = p.next;
        while (cnt-- > 0) {
            stack.push(q);
            q = q.next;
        }

        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }

        p.next = q;
        return dummy.next;
    }

    public static void main(String[] args) {
        String listStr = "[1,2,3,4,5]";
        listStr = listStr.replace("[", "").replace("]", "").replace(" ", "");
        String[] arr = listStr.split(",");
        int[] a = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for (int i=1; i<a.length;i++){
            cur.next = new ListNode(a[i]);
            cur = cur.next;
        }
        ReverseBetweenSolution solution = new ReverseBetweenSolution();
        ListNode h = solution.reverseBetween01(head,2, 3);
        ListNode c = h;
        while (c != null){
            System.out.print(c.val + ",");
            c = c.next;
        }
    }
}
