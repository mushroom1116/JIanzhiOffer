/**
 * Author: Wang Zhaorong
 * Date: 2018/3/22
 * Time: 21:38
 */
public class minNum {
    public static int minNum(String s)
    {
        char[] sChar = s.toCharArray();
        int[] numOfN = new int[10];
        //统计0~9出现的次数
        for(int i =0; i<sChar.length; i++)
        {
            numOfN[sChar[i] -'0'] += 1;
        }
        //找最小的次数
        int minNum = numOfN[1];
        int x = 0;
        for(int i=0; i<10; i++)
        {
            if(numOfN[i] < minNum)
            {
                minNum = numOfN[i];
                x = i;
            }
        }
        //若一套0~9都没有，则返回最小的出现0次的数字，0除外，要求正整数。
        if(minNum == 0)
        {
            int j=1;
            while(numOfN[j]!=0)
                j++;
            return j;
        }
        //否则返回minNum+1位的x
        int res = x;
        for(int i=1; i< minNum+1;i++)
        {
            res = res * 10 + x;
        }
        return res;
    }
    public static void main(String[] args)
    {
        //String s = "01234567891";
        String s = "112";
        int x = minNum(s);
        System.out.println(x);
    }
}
