package com.hisun.kont;

/**
 * @author ZHANG YI FA
 * @date 2020-12-19
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        oneNode.next = twoNode;
        ListNode thirdNode = new ListNode(3);
        twoNode.next = thirdNode;

        print("before reverse", oneNode);
        oneNode = reverseList(oneNode);
        print("after reverse", oneNode);
    }

    /**
     * 反转
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    /**
     * 打印
     */
    private static void print(String title, ListNode head) {
        System.out.println(title);
        ListNode listNode = head;
        while (listNode != null) {
            System.out.print(listNode.data + " -> ");
            listNode = listNode.next;
        }
        System.out.println("NULL");
    }

    /**
     * 结点
     */
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int x) {
            data = x;
        }
    }
}
