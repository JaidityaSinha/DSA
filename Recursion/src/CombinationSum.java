import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        recurse(candidates, target, 0, current);

        return list;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> current) {
        if (index == candidates.length) {
            if (target == 0)
                list.add(new ArrayList<>(current));

            return;
        }

        if (candidates[index] <= target) {
            current.add(candidates[index]);
            recurse(candidates, target - candidates[index], index, current);
            current.removeLast();
        }
        recurse(candidates, target, index + 1, current);
    }
}
