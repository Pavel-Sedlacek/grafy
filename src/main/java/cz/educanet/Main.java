package cz.educanet;

import cz.educanet.queue.FIFOQueue;
import cz.educanet.queue.FasterFIFOQueue;
import cz.educanet.queue.IQueue;
import cz.educanet.queue.LIFOQueue;

import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IQueue<Integer> q = new FIFOQueue<>();
        Main.processQueue(q);

        List<Integer> l = new LinkedList<>();
        LinkedList<Integer> ll = new LinkedList<>();

        while (!q.isEmpty()) {
            int a = q.dequeue();

            // ..
        }
    }

    static void processQueue(IQueue<Integer> a) {

    }
}