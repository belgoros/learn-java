package com.sca.calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * To know more about WHY RPN - Reverse Polish notation
 *
 * @author scambour
 * @see http://en.wikipedia.org/wiki/Reverse_Polish_notation
 */
public class RpnCalculator {
    private static final List<String> OPS = asList("-", "+", "*", "/");
    private final Deque<Number> stack = new LinkedList<Number>();

    public void push(Object arg) {
        if (OPS.contains(arg)) {
            Number y = stack.removeLast();
            Number x = stack.isEmpty() ? 0 : stack.removeLast();
            Double val = null;
            if (arg.equals("-")) {
                val = x.doubleValue() - y.doubleValue();
            } else if (arg.equals("+")) {
                val = x.doubleValue() + y.doubleValue();
            } else if (arg.equals("*")) {
                val = x.doubleValue() * y.doubleValue();
            } else if (arg.equals("/")) {
                val = x.doubleValue() / y.doubleValue();
            }
            push(val);
        } else {
            stack.add((Number) arg);
        }
    }

    public void PI() {
        push(Math.PI);
    }

    public Number value() {
        return stack.getLast();
    }
}
