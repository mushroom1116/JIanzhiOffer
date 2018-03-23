import java.util.Stack;

/**
 * Author: Wang Zhaorong
 * Date: 2018/3/8
 * Time: 9:08
 * 将每次压栈时的当前最小元素保存在辅助栈中
 */
public class MinStack {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> helpStack = new Stack<>();

    public void push(int value)
    {
        data.push(value);
        if(helpStack.size() == 0 || value < helpStack.peek())
            helpStack.push(value);
        else helpStack.push(helpStack.peek());
    }
    public void pop()
    {
        assert helpStack.size() > 0 && data.size()>0;
        data.pop();
        helpStack.pop();
    }

    public int min()
    {
        assert helpStack.size()>0 && data.size()>0;
        return helpStack.peek();
    }
    public static void main(String[] args)
    {
        MinStack a = new MinStack();
        a.push(2);
        a.push(1);
        a.push(3);
        a.push(4);

        System.out.println(a.min());

        a.pop();
        a.pop();
        a.pop();
        System.out.println(a.min());

    }
}
