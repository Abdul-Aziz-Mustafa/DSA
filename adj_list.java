
import java.util.*;

public class adj_list {

    static class edge {
        int self_name, dst, wt;

        // for weighted graph//
        public edge(int self_name, int dst, int wt) {
            this.self_name = self_name;
            this.dst = dst;
            this.wt = wt;
        }

        // for unweighted graph//
        public edge(int self_name, int dst) {
            this.self_name = self_name;
            this.dst = dst;
        }

    }

    static class Graph {
        int vertices;
        ArrayList<edge>[] adjlist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjlist = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjlist[i] = new ArrayList<>();
            }
        }

        // for weighted graph//
        public void addedge(int self_name, int dst, int wt) {
            edge edge = new edge(self_name, dst, wt);
            edge redge = new edge(dst, self_name, wt);
            adjlist[self_name].add(edge);
            adjlist[dst].add(redge);
        }

        // for unweighted graph//
        public void addedge(int self_name, int dst) {
            edge edge = new edge(self_name, dst);
            edge redge = new edge(dst, self_name);
            adjlist[self_name].add(edge);
            adjlist[dst].add(redge);
        }

        public void printgraph() {
            for (int i = 0; i < vertices; i++) {
                for (edge e : adjlist[i]) {
                    System.out.println("vertex-" + e.self_name + " is connected to " + e.dst);
                }
            }

        }

    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter number of edges");
        // int v = sc.nextInt();
        Graph graph = new Graph(7);

        graph.addedge(0, 3);
        graph.addedge(0, 1);
        graph.addedge(1, 2);
        graph.addedge(3, 4);
        graph.addedge(2, 3);
        graph.addedge(4, 5);
        graph.addedge(5, 6);
        graph.printgraph();
    }
}