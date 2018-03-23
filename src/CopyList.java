/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 19:36
 */
public class CopyList {
    class ComplexList
    {
        private int value;
        private ComplexList next;
        private ComplexList sibling;
        public ComplexList(int value)
        {
            this.value = value;
        }
    }

    public void clone(ComplexList head)
    {
        ComplexList pNode = head;
        while(pNode != null)
        {
            ComplexList clonedNode = new ComplexList(pNode.value);
            clonedNode.next = pNode.next;
            pNode.next = clonedNode;
            pNode = clonedNode.next;
        }
    }
    public void connectSubling(ComplexList head)
    {
        ComplexList pNode = head;
        while(pNode != null)
        {
            ComplexList clonedNode = pNode.next;
            if(pNode.sibling != null)
                clonedNode.sibling = pNode.sibling.next;
            pNode = clonedNode.next;
        }
    }
    public ComplexList reconnect(ComplexList head)
    {
        ComplexList pNode = head;
        ComplexList clonedHead = null;
        ComplexList clonedNode = null;

        if(pNode != null)
        {
            clonedHead = clonedNode =  pNode.next;
            pNode.next = clonedHead.next;
            pNode = pNode.next;
        }
        while (pNode != null)
        {
            clonedNode.next = pNode.next;
            clonedNode = clonedNode.next;
            pNode.next = clonedNode.next;
            pNode = pNode.next;

        }
        return clonedHead;
    }
    public ComplexList copy(ComplexList head)
    {
        clone(head);
        connectSubling(head);
        return reconnect(head);
    }

    public static void main(String[] args)
    {
        ComplexList a1 = new CopyList().new ComplexList(1);
        ComplexList a2 = new CopyList().new ComplexList(2);
        ComplexList a3 = new CopyList().new ComplexList(3);
        ComplexList a4 = new CopyList().new ComplexList(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        a1.sibling = a4;
        a3.sibling = a1;

        CopyList m = new CopyList();
        ComplexList b1 = m.copy(a1);
        ComplexList pNode = b1;
        while (pNode != null)
        {
            System.out.print(pNode.value+" ");

//            System.out.print(pNode.next.value+" ");
            if(pNode.sibling != null)
                System.out.print(pNode.sibling.value+" ");

            pNode = pNode.next;
        }
    }

}
