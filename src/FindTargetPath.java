import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 11:57
 */
public class FindTargetPath {
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

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode tree, int target)
    {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if(tree == null)
            return listAll;
        Stack<Integer> path = new Stack<Integer>();
        findPath(tree, target, path, listAll);
        return listAll;
    }

    public static void findPath(TreeNode tree, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> listAll)
    {
        if(tree == null)
            return;
        if(tree.left==null && tree.right==null)
        {
            if(tree.value==target)
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i : path)
                    list.add(i);
                list.add(tree.value);
                listAll.add(list);
            }
        }
        else{
            path.push(tree.value);
            findPath(tree.left,target-tree.value,path,listAll);
            findPath(tree.right,target-tree.value,path,listAll);
            path.pop();
        }
    }

    public static void main(String[] args)
    {
        TreeNode a1 = new FindTargetPath().new TreeNode(10);
        TreeNode a2 = new FindTargetPath().new TreeNode(5);
        TreeNode a3 = new FindTargetPath().new TreeNode(12);
        TreeNode a4 = new FindTargetPath().new TreeNode(4);
        TreeNode a5 = new FindTargetPath().new TreeNode(7);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        listAll = findPath(a1, 22);
        for (ArrayList<Integer> i : listAll)
        {
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        }


    }
}
