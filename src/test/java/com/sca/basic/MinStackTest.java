package com.sca.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    private MinStack stack;

    @BeforeEach
    void setUp() {
        stack = new MinStack();
    }

    @Test
    void popOnEmptyStackThrows() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void topOnEmptyStackThrows() {
        assertThrows(EmptyStackException.class, stack::top);
    }

    @Test
    void getMinOnEmptyStackThrows() {
        assertThrows(EmptyStackException.class, stack::getMin);
    }

    @Test
    void pushAndTopReturnLastPushed() {
        stack.push(3);
        stack.push(7);
        assertEquals(7, stack.top());
    }

    @Test
    void popRemovesAndReturnsTop() {
        stack.push(5);
        stack.push(9);
        assertEquals(9, stack.pop());
        assertEquals(5, stack.top());
    }

    @Test
    void getMinAscendingSequence() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.getMin());
    }

    @Test
    void getMinDescendingSequence() {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        assertEquals(1, stack.getMin());
    }

    @Test
    void getMinAfterPoppingCurrentMin() {
        stack.push(5);
        stack.push(1);
        stack.push(3);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(5, stack.getMin());
    }

    @Test
    void getMinWithDuplicateMinValues() {
        stack.push(2);
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
    }

    @Test
    void topDoesNotRemoveElement() {
        stack.push(4);
        stack.top();
        stack.top();
        assertEquals(4, stack.pop());
        assertThrows(EmptyStackException.class, stack::top);
    }
}
