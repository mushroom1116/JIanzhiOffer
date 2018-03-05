import com.sun.org.apache.regexp.internal.RE;
import sun.reflect.generics.tree.Tree;

/**
 * @author Wang Zhaorong
 * @date 2018/2/27.
 */
public class RebuildBinaryTree {
    //内部类TreeNode
    public class TreeNode
    {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value)
        {
            this.value = value;
        }

    }

    //重构二叉树的函数，返回二叉树
    public static TreeNode RebuildBinaryTree(int[] pre, int[] in)
    {
        //调用一个同名静态private函数
        TreeNode root = RebuildBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1 );
        return root;
    }
    /**
     * 根据前序中序数组构建二叉树，给出前序数组pre和中序数组in，再给在前序中序中节点的位置
     * @param pre 前序数组
     * @param startPre 节点在pre中的位置起点
     * @param endPre 节点在pre中位置终点
     * @param in 中序数组
     * @param startIn 节点在pre中的位置起点
     * @param endIn 节点在pre中位置终点
     * */
    private static TreeNode RebuildBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn)
    {
        if(startPre>endPre || startIn>endIn)
            return null;
        //前序pre的第一个元素是要构建的二叉树的根节点
        TreeNode root = new RebuildBinaryTree().new TreeNode(pre[startPre]);

        for(int i=0; i<=endIn;i++)
        {
            //找到根节点在中序in中的位置
            if(in[i] == pre[startPre])
            {
                //根节点的左子树元素在pre中从startPre+1直到start+(i-startIn)，在in中从startIn到i-1
                root.left = RebuildBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //根节点的左子树元素在pre中从startPre+(i-startIn)+1直到endPre，在in中从i+1到endIn
                root.right = RebuildBinaryTree(pre,  startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
    //按照前序递归打印treeNode，这也是二叉树的前序遍历方法
    public static void printTree(TreeNode treeNode)
    {
        if(treeNode != null)
        {
            System.out.println(treeNode.value);
            printTree(treeNode.left);
            printTree(treeNode.right);
        }
        else return;
    }

    public static void main(String[] args)
    {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode t = RebuildBinaryTree(pre, in);
        printTree(t);
    }
}
