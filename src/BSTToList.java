import sun.reflect.generics.tree.Tree;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 21:25
 */
public class BSTToList {
    class TreeNode
    {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value)
        {
            this.value = value;
        }
    }

    public static TreeNode convert(TreeNode tree)
    {
        TreeNode lastNodeInList = null;
        lastNodeInList = convert(tree, lastNodeInList);
        TreeNode head = lastNodeInList;
        while(head!=null && head.left!=null)
            head = head.left;
        return head;
    }
    public static TreeNode convert(TreeNode tree, TreeNode lastNodeInList)
    {
        if(tree == null)
            return null;
        TreeNode current = tree;
        if(current.left != null)
            lastNodeInList = convert(current.left, lastNodeInList);
        current.left = lastNodeInList;
        if(lastNodeInList != null)
        {
            lastNodeInList.right = current;
        }
        lastNodeInList = current;
        if(current.right != null)
            lastNodeInList = convert(current.right, lastNodeInList);
        return lastNodeInList;

    }

    public static void main(String[] args)
    {
        TreeNode a1 = new BSTToList().new TreeNode(10);
        TreeNode a2 = new BSTToList().new TreeNode(6);
        TreeNode a3 = new BSTToList().new TreeNode(14);
        TreeNode a4 = new BSTToList().new TreeNode(4);
        TreeNode a5 = new BSTToList().new TreeNode(8);
        TreeNode a6 = new BSTToList().new TreeNode(12);
        TreeNode a7 = new BSTToList().new TreeNode(16);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;

        TreeNode listhead = convert(a1);
        TreeNode pNode = listhead;
        while (pNode != null)
        {
            System.out.print(pNode.value + " ");
            pNode = pNode.right;
        }

    }
}
