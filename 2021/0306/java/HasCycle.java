/**
 * @author ZHANG YI FA
 * @date 2021-03-06
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle/
 *
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        oneNode.next = twoNode;
        ListNode thirdNode = new ListNode(3);
        twoNode.next = thirdNode;
        ListNode fourNode = new ListNode(4);
        thirdNode.next = fourNode;
        fourNode.next = thirdNode;

        // 是否有环
        bool cycle = hasCycle(head);
        if (cycle) {
            print("YES");
        } else {
            print("NO");
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
