package Greedy;

import java.util.PriorityQueue;

public class NonOverlappingIntervals {
    private static class Pair {
        int start,end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(
                (a, b) ->
                {
                    if (a.end == b.end) {
                        return Integer.compare(a.start, b.start);
                    }

                    return Integer.compare(a.end, b.end);
                }
        );

        for (int[] interval : intervals)
            pairPriorityQueue.add(new Pair(interval[0], interval[1]));

        int count = 0;
        int finishTime = Integer.MIN_VALUE;

        while (!pairPriorityQueue.isEmpty()) {
            Pair curr = pairPriorityQueue.remove();

            if (curr.start < finishTime) {
                count++;
                continue;
            }

            finishTime = curr.end;
        }

        return count;
    }
}
