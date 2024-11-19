package cz.educanet;

import cz.educanet.graph.Graph;
import cz.educanet.graph.Vertex;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = createGraph("Graph A");

        List<Vertex> dijstra = g.dijkstra("A", "D");
        System.out.println("DSF visited nodes in this order:");
        for (Vertex vertex: dijstra) {
            System.out.print(vertex.getLabel() + " ");
        }
        System.out.println();
    }

    public static Graph createGraph(String name) {
        Graph g = new Graph(name);

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);

        a.addNeighbour(b, 3);
        b.addNeighbour(a, 3);

        a.addNeighbour(c,2);
        c.addNeighbour(a,2);

        c.addNeighbour(b,1);
        b.addNeighbour(c,1);

        c.addNeighbour(d,4);
        d.addNeighbour(c,4);

        b.addNeighbour(e,7);
        e.addNeighbour(b,7);
        return g;


    }
}

