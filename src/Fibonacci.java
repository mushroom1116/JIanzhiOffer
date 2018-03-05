/**
 * @author Wang Zhaorong
 * @date 2018/3/4.
 */
public class Fibonacci {
    public static long Fibonacci(int n)
    {
        int[] res = {0, 1};
        if(n<2)
            return res[n];
        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for(int i=2; i<=n; i++)
        {
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
    public static void main(String[] args)
    {
        int n = 2;
        long fibN = Fibonacci(n);
        System.out.println(fibN);
    }
}
