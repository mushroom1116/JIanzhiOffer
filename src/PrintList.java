import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Wang Zhaorong
 * @date 2018/2/26.
 */
public class PrintList {
    public class ListNode
    {
        private int value;
        private ListNode next = null;
        public ListNode(int value)
        {
            this.value = value;
        }
    }
    public static ArrayList<Integer> res = new ArrayList<>();
    public static ArrayList<Integer> PrintList(ListNode listNode)
    {
        if(listNode != null)
        {
            PrintList(listNode.next);
            res.add(listNode.value);
        }
        return res;
    }
    public static void main(String[] args)
    {
        PrintList.ListNode listNode0 = new PrintList().new ListNode(3);
        PrintList.ListNode listNode1= new PrintList().new ListNode(4);
        PrintList.ListNode listNode2= new PrintList().new ListNode(5);
        PrintList.ListNode listNode3= new PrintList().new ListNode(6);
        PrintList.ListNode listNode4= new PrintList().new ListNode(7);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        System.out.println(PrintList(listNode0).toString());
    }

}
