package cz.educanet.queue;

import cz.educanet.commons.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * A naive-ish priority queue implementation using a LinkedList and a
 * sort-on-insert principle. Much better implementation (via priority heaps)
 * is provided by the default java class [PriorityQueue]
 *
 * @param <T> generic of the raw data
 */
public class PriorityQueue<T> {

    /**
     * @param priority of this node
     * @param element raw stored data
     * @param <I> generic type of the data
     */
    private record PQueueNode<I>(int priority, I element) {}

    private final List<PQueueNode<T>> queue = new LinkedList<>();

    public void push(int priority, T element) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).priority < priority) {
                queue.add(i, new PQueueNode<>(priority, element));
                return;
            }
        }
        queue.add(new PQueueNode<>(priority, element));
    }

    public Pair<Integer, T> peek() {
        if (queue.isEmpty())
            return null;
        PQueueNode<T> p = queue.getFirst();
        return new Pair<>(p.priority, p.element);
    }

    public Pair<Integer, T> pop() {
        if (queue.isEmpty())
            return null;
        PQueueNode<T> p = queue.removeFirst();
        return new Pair<>(p.priority, p.element);
    }

    public boolean isEmpty() { return this.queue.isEmpty(); }

}
