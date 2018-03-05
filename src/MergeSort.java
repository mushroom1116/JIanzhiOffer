/**
 * @author Wang Zhaorong
 * @date 2018/3/5.
 */
public class MergeSort {
    public static int[] Sort(int[] a, int low, int high)
    {
        if(a==null || a.length<=0 || low<0 || high>=a.length)
            throw new RuntimeException("Valid array");
        int mid = (low + high) / 2;
        if(low < high)
        {
            Sort(a, low, mid);
            Sort(a, mid + 1, high);
            Merge(a, low, mid, high);
        }
        return a;
    }
    public static void Merge(int[] a, int low, int mid, int high)
    {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i<=mid && j<=high)
        {
            if(a[i] < a[j])
                temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i<=mid)
            temp[k++] = a[i++];
        while (j<=high)
            temp[k++] = a[j++];
        for(int h = 0; h<temp.length;h++)
            a[low+h] = temp[h];
    }
    public static void main(String[] args)
    {
        int[] a = {5, 4, 6, 7, 2, 1, 10};
        int[] res = Sort(a, 0, a.length-1);
        for(int num : res)
            System.out.print(num+" ");

    }
}
