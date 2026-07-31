package StackAndQueue.src;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;

        int[] answer = new int[n - k + 1];
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.removeFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.removeLast();

            deque.addLast(i);

            if (i >= k - 1)
                answer[m++] = nums[deque.peekFirst()];
        }

        return answer;
    }
}
