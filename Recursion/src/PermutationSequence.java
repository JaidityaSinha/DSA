import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] factorial = new int[n];

        factorial[0] = 1;

        for (int i = 1; i < n; i++)
            factorial[i] = factorial[i - 1] * i;

        for (int i = 1; i <= n; i++)
            list.add(i);

        k--;
        StringBuilder result = new StringBuilder();

        for (int i = n; i > 0; i--) {
            int index = k / factorial[i-1];
            result.append(list.get(index));
            list.remove(index);

            k %= factorial[i - 1];
        }

        return result.toString();
    }
}
