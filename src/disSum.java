import com.sun.xml.internal.bind.v2.model.runtime.RuntimeReferencePropertyInfo;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 22:24
 */
class disCum {
    public static int disSum(String s, String t)
    {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        if(sChar.length>10000 || tChar.length>10000)
            throw new RuntimeException("invalid input");
        if(sChar.length < tChar.length)
            throw new RuntimeException("s < t");

        int res = 0;
        for(int i = 0; i<=(sChar.length-tChar.length); i++)
        {
            int disCur = 0;
            for(int j = 0; j<tChar.length;j++)
            {
                if(sChar[i+j] != tChar[j])
                    disCur++;
            }
            res += disCur;
        }
        return res;
    }

    public static void main(String[] args)
    {
        String s = "abcdabc";
        String t = "abc";

        int res = disSum(s, t);
        System.out.println(res);

    }
}
