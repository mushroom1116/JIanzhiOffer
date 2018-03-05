/**
 * @author Wang Zhaorong
 * @date 2018/2/26.
 */
public class ReplaceBlank {
    public static String ReplaceBlank(String str)
    {
        if(str == null || str.length() <= 0)
            return null;

        int blankNum = 0;
        for(int i = 0; i<str.length();i++)
        {
            if(str.charAt(i) == ' ')
                blankNum++;
        }

        int newLength = str.length() + 2*blankNum;
        char[] newChar = new char[newLength];
        int left = str.length() - 1;
        int right = newLength - 1;
        for(;left>=0;left--)
        {
            if(str.charAt(left)==' ')
            {
                newChar[right--] = '0';
                newChar[right--] = '2';
                newChar[right--] = '%';
            }
            else newChar[right--] = str.charAt(left);
        }
        return new String(newChar);
    }
    public static void main(String[] args)
    {
        String in1 = "we are happy.";
        String in2 = null;
        String in3 = "";
        String in4 = " ";
        String in5 = "wearehappy.";

        System.out.println("out1:"+ReplaceBlank(in1));
        System.out.println("out2:"+ReplaceBlank(in2));
        System.out.println("out3:"+ReplaceBlank(in3));
        System.out.println("out4:"+ReplaceBlank(in4));
        System.out.println("out5:"+ReplaceBlank(in5));

    }
}
