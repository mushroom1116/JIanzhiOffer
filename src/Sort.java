import com.sun.deploy.security.ruleset.RuleParseException;
import com.sun.javafx.applet.ExperimentalExtensions;
import com.sun.javafx.geom.Matrix3f;
import com.sun.prism.sw.SWPipeline;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

import javax.management.RuntimeErrorException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.html.HTMLDocument;
import java.util.Queue;
import java.util.Random;

/**
 * @author Wang Zhaorong
 * @date 2018/2/28.
 */
public class Sort {

    /**
     * 插入排序*/
    public static int[] InsertSort(int[] a)
    {
        for(int i=0; i<a.length;i++)
        {
            int temp = a[i];
            int j;
            for(j=i; j>0 && a[j-1]>temp; j--)
            {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
        return a;
    }

    /**
     * 快排*/

    public static void QuickSort(int[] a, int start, int end)
    {
        if(start == end)
            return;

        int index = Partition(a, start, end);
        if(start < index)
            QuickSort(a, start, index-1);
        if(end > index)
            QuickSort(a, index+1, end);
    }

    public static void Swap(int[] a, int m, int n)
    {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public static int Partition(int[] a, int start, int end)
    {
        if(a == null || a.length<=0 || start<0 || end>=a.length)
            throw new RuntimeException();

        Random random = new Random();
        int index = random.nextInt(end-start) + start;
        Swap(a, index, end);

        int small = start-1;
        for(index=start; index<end; index++)
        {
            if(a[index] < a[end])
            {
                small++;
                if(index != small)
                    Swap(a, small, index);
            }
        }
        small++;
        Swap(a, small,end);
        return small;
    }
    public static void main(String[] args)
    {
        int[] a = {3,1,5,7,2,4,9,6,10,8};
         a = InsertSort(a);
        System.out.println("InsertSort:");
        /*QuickSort(a, 0, a.length-1);
        System.out.println("QuickSort:");*/
        for(int n:a)
        {
            System.out.print(n+" ");
        }

    }

}
