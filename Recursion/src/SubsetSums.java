import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSums {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> subsetSums(int[] arr) {
        Arrays.sort(arr);
        List<Integer> current = new ArrayList<>();
        recurse(arr, 0, current);


        return list;
    }

    private void recurse(int[] arr, int index, List<Integer> current) {
        int sum = 0;
        for (var num : current)
            sum += num;
        list.add(sum);

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            recurse(arr, i + 1, current);
            current.removeLast();
        }
    }
}
