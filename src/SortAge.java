/**
 * @author Wang Zhaorong
 * @date 2018/3/4.
 */
public class SortAge {
    public static void SortAge(int[] age) {
        if (age == null || age.length <= 0)
            return;
        final int oldestAge = 99;
        int[] timesOfAge = new int[oldestAge + 1];
        for (int i = 0; i < age.length; i++) {
            int a = age[i];
            if (a < 0 || a > oldestAge)
                throw new RuntimeException();
            timesOfAge[a]++;
        }
        int index = 0;
        for (int i = 0; i < timesOfAge.length; i++)
            for (int j = 0; j < timesOfAge[i]; j++)
            {
                age[index] = i;
                index++;
            }
    }
    public static void main(String[] args)
    {
        int[] age = {22,23,23,23,45,46,46,46,47,47,47,99,99,99,99};
        SortAge(age);
        for(int n:age)
        {
            System.out.print(n+" ");
        }
    }
}
