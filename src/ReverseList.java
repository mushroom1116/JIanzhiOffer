/**
 * Author: Wang Zhaorong
 * Date: 2018/3/7
 * Time: 20:06
 */
public class ReverseList {
    class ListNode
    {
        private int value;
        private ListNode next;

        public ListNode(int value)
        {
            this.value = value;
        }
    }

    public static ListNode reverseList(ListNode head)
    {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode pre = null;
        ListNode pNode = head;
        ListNode temp = null;
        ListNode newHead = null;

        while(pNode != null)
        {
            temp = pNode.next;
            if(temp == null)
                newHead = pNode;
            pNode.next = pre;
            pre = pNode;
            pNode = temp;
        }
        return newHead;
    }

    public static void main(String[] args)
    {
        ListNode a1 = new ReverseList().new ListNode(1);
        ListNode a2 = new ReverseList().new ListNode(2);
        ListNode a3 = new ReverseList().new ListNode(3);
        ListNode a4 = new ReverseList().new ListNode(4);
        ListNode a5 = new ReverseList().new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode newHead = reverseList(a1);
        ListNode p = newHead;
        while(p != null)
        {
            System.out.print(p.value + " ");
            p = p.next;
        }
    }
}
