import java.util.Stack;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 10:03
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] pushOrder, int[] popOrder)
    {
        if(pushOrder == null || popOrder == null || pushOrder.length<=0 || popOrder.length<=0)
            return false;
        int index = 0;
        Stack<Integer> s = new Stack<>();
        /**
         * 从压栈序列第一个元素开始，
         * 压栈并判断栈顶元素是否是弹出序列的当前元素，
         * 若不是，继续压栈，否则弹出，index指向弹出序列的下一个
         * 最终若s为空，证明完美的按照两个序列的安排弹完了。*/
        for(int i = 0; i< pushOrder.length; i++)
        {
            s.push(pushOrder[i]);
            /**
             * 如果栈顶元素不等于弹出序列的当前元素，
             * 则继续压栈，直到找到弹出序列的当前元素，若没有找到，则返回false；
             * 如果栈顶元素等于弹出序列的当前元素，则弹出，
             * 并且弹出序列指针后移，指向下一个待判断弹出元素。*/
            while(!s.empty())
            {
                if(s.peek() != popOrder[index])
                    break;
                s.pop();
                index++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args)
    {
        int[] pushA = {1,2,3,4,5};
        //int[] popA = {4,5,3,2,1};
        int[] popA = {4,5,3,1,2};
        System.out.print(isPopOrder(pushA,popA));
    }
}
