package cz.educanet.queue;

import java.util.*;


/**
 * A naive LIFO queue implementation, much better interface and
 * performance is provided by [Stack] or more preferably [Deque] structures
 */
public class LIFOQueue<T> implements IQueue<T> {

    private LinkedList<T> data = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public T dequeue() {
        return data.removeLast();
    }

    @Override
    public void enqueue(T element) {
        data.add(element);
    }
}
