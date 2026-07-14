import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        var buckets = createBuckets(numberOfBuckets, array);

        var i = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (var item : bucket) {
               array[i++] = item;
            }
        }
    }

    private List<List<Integer>> createBuckets(int numberOfBuckets, int[] array) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (int item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }
}
