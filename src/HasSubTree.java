/**
 * Author: Wang Zhaorong
 * Date: 2018/3/7
 * Time: 21:34
 */
public class HasSubTree {
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
    public static boolean hasSubTree(TreeNode tree1, TreeNode tree2)
    {
        boolean res = false;
        if(tree1 != null && tree2 != null)
        {
            if(tree1.value == tree2.value)
                res = DoesTree1HaveTree2(tree1, tree2);
            if(!res)
                res = hasSubTree(tree1.left, tree2);
            if(!res)
                res = hasSubTree(tree1.right,tree2);
        }
        return res;
    }

    public static boolean DoesTree1HaveTree2(TreeNode tree1, TreeNode tree2)
    {
        if (tree2 == null)
            return true;
        if(tree1 == null)
            return false;
        if(tree1.value != tree2.value)
            return false;

        return DoesTree1HaveTree2(tree1.left, tree2.left) && DoesTree1HaveTree2(tree1.right,tree2.right);
    }

    public static void main(String[] args)
    {
        TreeNode a1 = new HasSubTree().new TreeNode(1);
        TreeNode a2 = new HasSubTree().new TreeNode(2);
        TreeNode a3 = new HasSubTree().new TreeNode(3);
        TreeNode a4 = new HasSubTree().new TreeNode(4);
        TreeNode a5 = new HasSubTree().new TreeNode(5);
        TreeNode a6 = new HasSubTree().new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;

        /*TreeNode a1 = null;
        TreeNode a2 = null;*/

        boolean res = hasSubTree(a1, a2);
        System.out.println(res);
    }
}
