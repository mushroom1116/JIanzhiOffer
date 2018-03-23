import java.util.List;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/7
 * Time: 20:35
 */
public class MergeList {
    class ListNode
    {
        private int value;
        private ListNode next;
        public ListNode(int value)
        {
            this.value = value;
        }
    }
    public static ListNode merge1(ListNode list1, ListNode list2)
    {
        if(list1 == null && list2 == null)
            throw new RuntimeException("valid");
        else if (list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        ListNode p1 = null;
        ListNode p2 = null;

        ListNode newList = null;
        if(list1.value < list2.value)
        {
            newList = list1;
            p1 = list1.next;
            p2 = list2;
        }
        else
        {
            newList = list2;
            p2 = list2.next;
            p1 = list1;
        }

        ListNode q = newList;
        while(p1 != null && p2 != null)
        {
            if(p1.value < p2.value)
            {
                q.next = p1;
                q = p1;
                p1 = p1.next;
            }
            else
            {
                q.next = p2;
                q = p2;
                p2 = p2.next;
            }

        }
        if(p1 == null)
            q.next = p2;
        if (p2 == null)
            q.next = p1;
        return newList;
    }
    public static ListNode merge2(ListNode list1, ListNode list2)
    {
        if(list1 == null && list2 == null)
            throw new RuntimeException("valid");
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode newList = null;
        if(list1.value < list2.value)
        {
            newList = list1;
            newList.next = merge2(list1.next, list2);
        }
        else
        {
            newList = list2;
            newList.next = merge2(list1,list2.next);
        }
        return newList;

    }

    public static void main(String[] args)
    {
        ListNode a1 = new MergeList().new ListNode(1);
        ListNode a2 = new MergeList().new ListNode(3);
        ListNode a3 = new MergeList().new ListNode(5);
        ListNode a4 = new MergeList().new ListNode(7);
        ListNode a5 = new MergeList().new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        //ListNode b1 = null;
        ListNode b1 = new MergeList().new ListNode(2);
        ListNode b2 = new MergeList().new ListNode(4);
        ListNode b3 = new MergeList().new ListNode(6);
        ListNode b4 = new MergeList().new ListNode(8);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;


        ListNode newHead = merge2(a1, b1);
        ListNode p = newHead;
        while( p != null)
        {
            System.out.print(p.value + " ");
            p = p.next;
        }

    }
}
