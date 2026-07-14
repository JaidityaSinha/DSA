import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMultiplicationsToReachEnd {
    static final int MOD_VALUE = 1000;

    static class Pair {
        int steps, num;

        public Pair(int steps, int num) {
            this.steps = steps;
            this.num = num;
        }
    }

    public int minSteps(int[] arr, int start, int end) {
        int[] dist = new int[MOD_VALUE];
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.steps, b.steps)
        );

        priorityQueue.add(new Pair(dist[start], start));

        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();

            if (curr.steps > dist[curr.num])
                continue;

            for (int i = 0; i < arr.length; i++) {
                int next = (curr.num * arr[i]) % MOD_VALUE;

                if (dist[next] > curr.steps + 1) {
                    dist[next] = curr.steps + 1;
                    priorityQueue.add(new Pair(dist[next], next));
                }
            }
        }


        return (dist[end] == (int) 1e9) ? -1 : dist[end];
    }
}
