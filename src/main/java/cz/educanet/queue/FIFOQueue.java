package cz.educanet.queue;

import java.util.ArrayList;

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
