package com.sca.basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

public class MinStack {

    private final Deque<Integer> mainStack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) throw new EmptyStackException();
        int value = mainStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }

    public int top() {
        if (mainStack.isEmpty()) throw new EmptyStackException();
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) throw new EmptyStackException();
        return minStack.peek();
    }
}
