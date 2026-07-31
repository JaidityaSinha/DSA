package StackAndQueue.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
    private static class Pair {
        int price,span;

        public Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    ArrayDeque<Pair> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price)
            span += stack.pop().span;

        stack.push(new Pair(price, span));

        return span;
    }
}
