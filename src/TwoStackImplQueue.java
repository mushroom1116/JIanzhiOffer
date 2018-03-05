import java.util.Stack;
import java.util.concurrent.ExecutionException;

/**
 * @author Wang Zhaorong
 * @date 2018/2/27.
 */
public class TwoStackImplQueue {
    //初始化两个栈
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    //在队尾插入元素
    public static void appendTail(int data)
    {
        stack1.push(data);
    }

        //从队头删除元素
    public static int deleteHead()
    {
        //若stack2为空，则将stack1的元素pop过来
        if(stack2.size()<=0)
        {
            while(stack1.size()>0)
            {
                int data = stack1.peek();
                stack1.pop();
                stack2.push(data);
            }
        }
        //若此时stack2仍然为空，说明队列为空，发出异常
        if(stack2.isEmpty())
            throw new RuntimeException("queue is empty");

        //stack2不为空时，从stack2顶部删除元素
        int head = stack2.peek();
        stack2.pop();
        return head;
    }

    public static void main(String[] args)
    {
        appendTail(1);
        appendTail(2);
        appendTail(3);
        deleteHead();
        appendTail(4);

        System.out.println(stack1);
        System.out.println(stack2);
    }
}
