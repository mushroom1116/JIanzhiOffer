import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Wang Zhaorong
 * @date 2018/2/26.
 */
public class SortTwoArray {
    public static int[] SortTwoArray(int[] arr1, int[] arr2)
    {
        if(arr2 == null)
            return arr1;
        if(arr1 == null)
            return arr2;
        int arr1Length = 0;
        for(int i =0;i<arr1.length;i++)
        {
            if(arr1[i] !=0)
                arr1Length++;
            else break;
        }
        int newLength = arr1Length + arr2.length;
        int p1 = arr1Length-1;
        int p2 = arr2.length-1;
        int i = newLength-1;
        while(p1>=0 && p2>=0)
        {
            if(arr1[p1]>=arr2[p2])
            {
                arr1[i] = arr1[p1];
                p1--;
                i--;
            }
            else if(arr1[p1] < arr2[p2])
            {
                arr1[i] = arr2[p2];
                p2--;
                i--;
            }
            if(p1<0)
            {
                for(;i>=0;i--)
                    arr1[i] = arr2[p2--];
            }

        }
        return arr1;
    }
    public static void main(String[] args)
    {
        int[] arr1 = new int[100];
        for(int i = 0; i<5;i++)
            arr1[i] = 2*(i+1);
        int[] arr2 = {1,2,3,4,5};

        System.out.println("out:"+ Arrays.toString(SortTwoArray(arr1,arr2)));
    }
}
