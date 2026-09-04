package Greedy;

import java.util.*;

public class MaxMeetingsInOneRoom {
    private static class Triad {
        int start,finish,pos;

        public Triad(int start, int finish, int pos) {
            this.start = start;
            this.finish = finish;
            this.pos = pos;
        }
    }
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        PriorityQueue<Triad> priorityQueue = new PriorityQueue<>(
                (a, b) -> {
                    int finishComparison = Integer.compare(a.finish, b.finish);
                    return finishComparison != 0
                            ? finishComparison
                            : Integer.compare(a.pos, b.pos);
                }
        );

        for (int i = 0; i < s.length; i++)
            priorityQueue.add(new Triad(s[i], f[i], i + 1));

        int finishTime = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Triad current = priorityQueue.remove();

            if (finishTime >= current.start)
                continue;

            finishTime = current.finish;
            list.add(current.pos);
        }

        Collections.sort(list);

        return list;
    }
}
