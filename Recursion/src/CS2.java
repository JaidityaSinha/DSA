import java.util.*;

public class CS2 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        recurse(0, candidates, target, current);

        return list;
    }

    private void recurse(int index, int[] nums, int target, List<Integer> current) {

        if (target < 0)
            return;

        if (target == 0) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            recurse(i + 1, nums, target - nums[i], current);
            current.removeLast();
        }
    }
}
