package cz.educanet;

import cz.educanet.graph.Graph;
import cz.educanet.graph.Vertex;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = createGraph("Graph A");

        List<Vertex> dfs = g.depthFirstSearch();
        System.out.println("DSF visited nodes in this order:");
        for (Vertex vertex: dfs) {
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

        a.addNeighbour(b);
        b.addNeighbour(a);

        a.addNeighbour(c);
        c.addNeighbour(a);

        c.addNeighbour(b);
        b.addNeighbour(c);

        c.addNeighbour(d);
        d.addNeighbour(c);

        return g;
    }
}

