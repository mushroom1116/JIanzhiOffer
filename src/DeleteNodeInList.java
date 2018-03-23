/**
 * Author: Wang Zhaorong
 * Date: 2018/3/6
 * Time: 21:31
 */
public class DeleteNodeInList {
    public class ListNode
    {
        private int value;
        private ListNode next;
        public ListNode(int value)
        {
            this.value = value;
        }
    }
    public static void deleteListNode(ListNode head, ListNode toBeDelete)
    {
        if(head==null || toBeDelete==null)
            return;
        if(toBeDelete.next != null)
        {
            ListNode temp = toBeDelete.next;
            toBeDelete.value = temp.value;
            toBeDelete.next = temp.next;
            toBeDelete = null;
        }
        else if (head==toBeDelete)
            head=null;
        else{
            ListNode p = head;
            while(p.next != toBeDelete)
            {
                p = p.next;
            }
            p.next = null;
        }

    }
    public static void main(String[] args)
    {
        ListNode node1 = new DeleteNodeInList().new ListNode(1);
        ListNode node2 = new DeleteNodeInList().new ListNode(2);
        ListNode node3 = new DeleteNodeInList().new ListNode(3);
        ListNode node4 = new DeleteNodeInList().new ListNode(4);
        ListNode node5 = new DeleteNodeInList().new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        deleteListNode(node1,node1);

        ListNode n = node1;
        while (n.next != null)
        {
            System.out.print(n.value);
            n = n.next;
        }
        System.out.print(n.value);

    }
}
