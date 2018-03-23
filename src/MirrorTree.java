/**
 * Author: Wang Zhaorong
 * Date: 2018/3/7
 * Time: 22:03
 */
public class MirrorTree {

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

    public static TreeNode mirror(TreeNode t)
    {
        if(t == null)
            return null;
        if(t.left == null && t.right == null)
            return t;
        TreeNode temp = t.left;
        t.left = t.right;
        t.right = temp;
        if(t.left != null)
            mirror(t.left);
        if(t.right != null)
            mirror(t.right);
        return t;
    }
    public static void main(String[] args)
    {
        TreeNode a1 = new MirrorTree().new TreeNode(1);
        TreeNode a2 = new MirrorTree().new TreeNode(2);
        TreeNode a3 = new MirrorTree().new TreeNode(3);
        TreeNode a4 = new MirrorTree().new TreeNode(4);
        TreeNode a5 = new MirrorTree().new TreeNode(5);
        TreeNode a6 = new MirrorTree().new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;

        a1 = mirror(a1);
        printPre(a1);

    }

    public static void printPre(TreeNode t)
    {
        if(t != null)
        {
            System.out.print(t.value);
            printPre(t.left);
            printPre(t.right);
        }

    }
}

