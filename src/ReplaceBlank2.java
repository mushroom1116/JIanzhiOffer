/**
 * @author Wang Zhaorong
 * @date 2018/2/26.
 */
public class ReplaceBlank2 {
    public static String ReplaceBlank2(String str)
    {
        if(str == null || str.length()<=0)
            return null;
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
                sb.append("%20");
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        String in1 = "we are happy.";
        String in2 = null;
        String in3 = "";
        String in4 = " ";
        String in5 = "wearehappy.";

        System.out.println("out1:"+ReplaceBlank2(in1));
        System.out.println("out2:"+ReplaceBlank2(in2));
        System.out.println("out3:"+ReplaceBlank2(in3));
        System.out.println("out4:"+ReplaceBlank2(in4));
        System.out.println("out5:"+ReplaceBlank2(in5));

    }
}
