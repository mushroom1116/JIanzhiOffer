/**
 * Author: Wang Zhaorong
 * Date: 2018/3/6
 * Time: 22:24
 */
public class FindKReverseInList {
    class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value)
        {this.value = value;}
    }
    public static ListNode findKReverse(ListNode head, int k)
    {
        if(head == null || k==0)
            throw new RuntimeException("valid 1");
        ListNode fast = head;
        for(int i=0;i<k-1;i++)
        {
            if(fast.next != null)
                fast=fast.next;
            else
                throw new RuntimeException("valid 2");
        }
        ListNode low = head;
        while (fast.next != null)
        {
            fast=fast.next;
            low=low.next;
        }
        return low;
    }

    public static void main(String[] args)
    {
        ListNode node1 = new FindKReverseInList().new ListNode(1);
        ListNode node2 = new FindKReverseInList().new ListNode(2);
        ListNode node3 = new FindKReverseInList().new ListNode(3);
        ListNode node4 = new FindKReverseInList().new ListNode(4);
        ListNode node5 = new FindKReverseInList().new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode a1 = findKReverse(node1,1);
        System.out.println(a1.value);
        ListNode a2 = findKReverse(node1,5);
        System.out.println(a2.value);
        ListNode a3 = findKReverse(node1,6);
        System.out.println(a3.value);

    }
}
