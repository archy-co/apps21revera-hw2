package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue () {
        queue = new ImmutableLinkedList();
    }

    public Queue (Object [] elements) {
        queue = new ImmutableLinkedList(elements);
    }

    public Object peek() {
        return queue.getFirst();
    }

    public Object dequeue() {
        Object firstElem = queue.getFirst();
        queue = queue.removeFirst();
        return firstElem;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
