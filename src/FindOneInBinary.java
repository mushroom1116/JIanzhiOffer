/**
 * Author: Wang Zhaorong
 * Date: 2018/3/5
 * Time: 19:44
 */
public class FindOneInBinary {
    public static int FindOneInBinary(int n)
    {
        int count = 0;
        while(n != 0)
        {
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args)
    {
        int n = 10;
        int count = FindOneInBinary(n);
        System.out.println(count);
    }
}

