package cz.educanet.queue;

public interface IQueue<T> {

    public boolean isEmpty();
    public T dequeue();
    public void enqueue(T element);
}
