import java.security.cert.TrustAnchor;

/**
 * @author Wang Zhaorong
 * @date 2018/2/26.
 */
public class TwoDArraySearch {

    public static boolean TwoDArraySearch(int[][] twoDArray, int target)
    {
        //边角判断
        if(twoDArray == null)
            return false;
        if(twoDArray.length == 0)
            return false;
        if(twoDArray[0].length == 0)
            return false;
        //一般情况
        int row = 0;
        int col = twoDArray[0].length-1;
        while(row<twoDArray.length && col>=0)
        {
            if(twoDArray[row][col] == target)
                return true;
            else if (twoDArray[row][col] < target)
                row++;
            else col--;
        }
        return false;
    }
    public static void main(String[] args)
    {
        int[][] in1 = {{1,2,3},{2,3,4},{3,4,5}};
        int[][] in2 = {{1},{2},{3}};
        int[][] in3 = {{1,2,3}};
        int[][] in4 = {};
        int[][] in5 = {{},{},{}};
        int[][] in6 = null;

        System.out.println("out1:"+TwoDArraySearch(in1,8));
        System.out.println("out2:"+TwoDArraySearch(in2,2));
        System.out.println("out3:"+TwoDArraySearch(in3,2));
        System.out.println("out4:"+TwoDArraySearch(in4,2));
        System.out.println("out5:"+TwoDArraySearch(in5,2));
        System.out.println("out6:"+TwoDArraySearch(in6,2));
    }
}
