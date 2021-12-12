package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;
    public Stack () {
        stack = new ImmutableLinkedList();
    }

    public Stack (Object [] elements) {
        stack = new ImmutableLinkedList(elements);
    }

    public void push(Object e) {
        stack = stack.addLast(e);
    }

    public Object pop() {
        Object topElem = stack.getLast();
        stack = stack.removeLast();
        return topElem;
    }

    public Object peek() {
        return stack.getLast();
    }
}
