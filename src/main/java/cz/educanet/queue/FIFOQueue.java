package cz.educanet.queue;

import java.util.ArrayList;

/**
 * A naive FIFO queue implementation, much better interface and
 * performance is provided by [ArrayList] class
 */
public class FIFOQueue<T> implements IQueue<T> {

    private ArrayList<T> data = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public T dequeue() {
        return data.removeFirst();
    }

    @Override
    public void enqueue(T element) {
        data.add(element);
    }

    public void clear() {
        data.clear();
    }
}
