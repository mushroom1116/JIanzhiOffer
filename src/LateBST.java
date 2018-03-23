/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 11:06
 */
public class LateBST {
    public static boolean VerifySequenceOfBST(int[] lateOrder)
    {
        if (lateOrder == null || lateOrder.length<=0)
            return false;
        return isTreeBST(lateOrder, 0, lateOrder.length-1);
    }
    public static boolean isTreeBST(int[] sequence, int start, int end)
    {
        if(start == end)
            return true;
        int index = start;
        for(; index<end;index++)
        {
            if(sequence[index] > sequence[end])
                break;
        }
        for(int j = index; j<end;j++)
        {
            if(sequence[j] < sequence[end])
                return false;
        }
        boolean resLeft = true;
        if (index>0)
            resLeft = isTreeBST(sequence,start,index-1);
        boolean resRight = true;
        if(end>0)
            resRight = isTreeBST(sequence,index,end-1);
        return resLeft && resRight;
    }

    public static void main(String[] args)
    {
        //int[] sequence = {5,7,6,9,11,10,8};
        //int[] sequence = {7,4,6,5};
        int[] sequence = {9,8,7,6};
        boolean res = VerifySequenceOfBST(sequence);
        System.out.println(res);
    }
}
