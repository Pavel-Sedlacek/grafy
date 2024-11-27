package cz.educanet;

import cz.educanet.graph.Graph;
import cz.educanet.graph.Vertex;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = createGraph("Graph A");

        List<Vertex> dijkstra = g.dijkstra("A", "D");
        System.out.println("Dijkstra visited nodes in this order:");
        for (Vertex vertex: dijkstra) {
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

        c.addNeighbour(b,20);
        b.addNeighbour(c,20);

        c.addNeighbour(d,21);
        d.addNeighbour(c,21);

        b.addNeighbour(d,1);
        d.addNeighbour(b,1);
        return g;


    }
}

