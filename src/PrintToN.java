import java.security.cert.TrustAnchor;

/**
 * @author Wang Zhaorong
 * @date 2018/3/5.
 */
public class PrintToN {
    public static void PrintToN(int n)
    {
        if(n <= 0)
            return;
        char[] res = new char[n];
        for(int i=0; i<n; i++)
            res[i] = '0';
        while (!Increment(res))
            PrintNumber(res);
    }

    public static boolean Increment(char[] res)
    {
        boolean overFlow = false; //溢出标志位
        int nTakeOver = 0;  //进位标志位

        for(int i=res.length-1; i>=0; i--)
        {
            int nSum  = res[i] -'0'+nTakeOver;
            if(i == res.length-1)
                nSum++;
            if(nSum >=10)
            {
                if(i == 0)
                    overFlow = true;
                else {
                    nSum = nSum - 10;
                    nTakeOver = 1;
                    res[i] = (char)(nSum + '0') ;
                }
            }else
            {
                res[i] = (char)(nSum + '0');
                break;
            }
        }
        return overFlow;
    }
    public static void PrintNumber(char[] res)
    {
        boolean isBegin0 = true;
        for(int i=0; i<res.length; i++)
        {
            if(isBegin0 && res[i]!='0')
                isBegin0 = false;
            if(!isBegin0)
                System.out.print(res[i]);
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        int n = 2;
        PrintToN(n);
    }
}
