import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 10:23
 */
public class BFSTree {
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
    public static void printBFS(TreeNode tree)
    {
        Queue<TreeNode> queue = new LinkedList<BFSTree.TreeNode>();
        queue.offer(tree);
        TreeNode temp = null;
        while (!queue.isEmpty())
        {
            temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.offer(temp.left);
            if(temp.right  != null)
            queue.offer(temp.right);
        }
    }
    public static void main(String[] args)
    {
        TreeNode a1 = new BFSTree().new TreeNode(1);
        TreeNode a2 = new BFSTree().new TreeNode(2);
        TreeNode a3 = new BFSTree().new TreeNode(3);
        TreeNode a4 = new BFSTree().new TreeNode(4);
        TreeNode a5 = new BFSTree().new TreeNode(5);
        TreeNode a6 = new BFSTree().new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;

        printBFS(a1);
    }
}
