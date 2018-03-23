/**
 * Author: Wang Zhaorong
 * Date: 2018/3/7
 * Time: 22:25
 */
public class PrintMtrixClock {
    public static void printMtrixClock(int[][] mtrix)
    {
        if (mtrix == null || mtrix.length<=0 || mtrix[0].length<=0)
            throw new RuntimeException("valid");

        int start = 0;
        while(start * 2 < mtrix.length && start * 2 < mtrix[0].length)
        {
            printMtrixByCircle(mtrix, start);
            start++;
        }
    }
    public static void printMtrixByCircle(int[][] mtrix, int start)
    {
        int endX = mtrix.length - start - 1;
        int endY = mtrix[0].length  - start - 1;
        for(int i = start; i <= endY; i++)
        {
            System.out.print(mtrix[start][i]+" ");
        }
        if(endX > start)
        {
            for(int i = start +1 ;i <= endX;i++ )
                System.out.print(mtrix[i][endY]+" ");
        }

        if(endX > start && endY > start)
        {
            for(int i = endY - 1; i >= start; i--)
                System.out.print(mtrix[endX][i]+" ");
        }
        if(endY > start && endX-1 > start )
        {
            for (int i = endX - 1; i> start; i--)
                System.out.print(mtrix[i][start]+" ");
        }
    }

    public static void main(String[] args)
    {
        int[][] mtrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMtrixClock(mtrix);
    }
}
