package wise.liu.datastructure.collection.list.exercises;

import wise.liu.datastructure.collection.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.07. 链表相交
 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。


 示例 1：

 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 输出：Reference of the node with value = 8
 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

 示例 2：

 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 输出：Reference of the node with value = 2
 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

 示例 3：

 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 输出：null
 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 解释：这两个链表不相交，因此返回 null。

 注意：

 如果两个链表没有交点，返回 null 。
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci

 * @author wise liu
 * @date 2020/11/25
 */
public class ListIntersectionNodeSolution {
    /**
     * 思路： 先求出两个链表相差几个节点 先让长的链表先跑几步 然后两个链表同时走
     * 第一个相等的节点就是相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode0(ListNode headA, ListNode headB) {
        if(headA == null || headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        ListNode a = headA;
        ListNode b = headB;
        int aTimes = 0;
        int bTimes = 0;
        while(true){
            if(a.next != null){
                a = a.next;
                aTimes++;
            }
            if(b.next != null){
                b = b.next;
                bTimes++;
            }
            if(a.next == null && b.next == null){
                break;
            }
        }
        System.out.println(aTimes+","+bTimes);
        ListNode a1 = headA;
        ListNode b1 = headB;
        if(aTimes>bTimes){
            int l = aTimes - bTimes;
            for(int i = 0; i<l; i++){
                a1 = a1.next;
            }
            if(a1==b1){
                return a1;
            }
            while(a1.next!=null){
                a1 = a1.next;
                b1 = b1.next;
                if(a1==b1){
                    return b1;
                }
            }
        }else if(aTimes<bTimes){
            int l = bTimes - aTimes;
            for(int i = 0; i<l; i++){
                b1 = b1.next;
            }
            if(a1==b1){
                return a1;
            }
            while(a1.next!=null){
                a1 = a1.next;
                b1 = b1.next;
                if(a1==b1){
                    return b1;
                }
            }
        }else{
            while(a1.next!=null){
                a1 = a1.next;
                b1 = b1.next;
                if(a1==b1){
                    return b1;
                }
            }
        }

        return null;
    }

    /**
     * 用set存第一个链表的节点 遍历第二个链表
     * 第一个重复的节点就是相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode a = headA;
        while(a != null){
            set.add(a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null){
            if (set.contains(b)){
                return b;
            }
            b = b.next;
        }
        return null;
    }

    /**
     * 双指针
     * 同时遍历链表a、b 不相等就继续遍历 空了（遍历完了）换成另一个链表头节点
     * 长短链接交换后 如果相交 第一个相等节点就是相交节点
     * 如果不想交 就会同时为null(结束)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }

        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }

        return a;
    }
}
