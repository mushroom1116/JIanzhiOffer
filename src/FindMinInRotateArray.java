/**
 * @author Wang Zhaorong
 * @date 2018/3/4.
 */
public class FindMinInRotateArray {
    public static int FindMinInRotateArray(int[] num)
    {
        if(num == null || num.length <= 0)
            throw new RuntimeException("Invalid num");

        int index1 = 0;
        int index2 = num.length - 1;
        int indexMid = 0;
        while (num[index1] >= num[index2])
        {
            if(index2 - index1 == 1)
            {
                indexMid = index2;
                break;
            }

            indexMid = (index2 + index1) / 2;
            if(num[index1] == num[index2] && num[indexMid] == num[index1])
                return MinInOrder(num, index1, index2);
            if(num[indexMid] >= num[index1])
                index1 = indexMid;
            else if(num[indexMid] <= num[index2])
                index2 = indexMid;
            }
        return num[indexMid];
    }
    public static int MinInOrder(int[] num, int index1, int index2)
    {
        int res = num[index1];
        for(int i=index1+1; i<=index2;i++)
        {
            if(num[i] < res)
                res = num[i];
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] num1 = {5,6,7,8,9,10,11,2,2,2,3,4};
        int[] num2 = {1,2,3,4,5,6,7};
        int[] num3 = {1};
        int[] num4 = null;
        int min = FindMinInRotateArray(num1);
        System.out.println("min:"+min);
    }
}
