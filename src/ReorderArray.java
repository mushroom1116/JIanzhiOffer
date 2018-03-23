/**
 * Author: Wang Zhaorong
 * Date: 2018/3/6
 * Time: 22:05
 */
public class ReorderArray {
    public static void reorderArray(int[] a)
    {
        if(a == null || a.length<=0)
            return;
        int l = 0;
        int h = a.length-1;
        while(l < h)
        {
            while(l<h && isOdd(a[l]))
                l++;
            while (l<h && !isOdd(a[h]))
                h--;
            if(l < h)
            {
                int temp = a[l];
                a[l] = a[h];
                a[h] = temp;
            }
        }
    }
    public static boolean isOdd(int n)
    {
        if(n %2 == 0)
            return false;
        else return true;
    }
    public static void main(String[] args)
    {
        int[] a = {2,3,4,5,6,7};
        reorderArray(a);
        for(int num: a)
            System.out.print(num+ " ");
    }
}
