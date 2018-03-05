import java.util.DoubleSummaryStatistics;

/**
 * @author Wang Zhaorong
 * @date 2018/3/5.
 */
public class NPower {
    public static double nPower(double base, int exponent)
    {
        if(Double.compare(base, 0.0)==0 && exponent < 0)
            throw new RuntimeException("Valid");

        int absExponent = exponent>=0 ? exponent:-exponent;
        double res = 1;

        for(int i=1; i<=absExponent;i++)
            res *= base;

        if(exponent<0)
            res = 1 / res;
        return res;
    }
    public static void main(String[] args)
    {
//        double res = nPower(2, 3);
//        double res = nPower(0.0, -2);
//        double res = nPower(3,-1);
        double res = nPower(-3,-1);
        System.out.println(res);
    }
}
