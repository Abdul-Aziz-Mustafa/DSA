import java.util.*;

public class dsf_adjlist {

    static class edge {
        int source, dst, wt;

        // for weighted graph//
        public edge(int source, int dst, int wt) {
            this.source = source;
            this.dst = dst;
            this.wt = wt;
        }

        // for unweighted graph//
        public edge(int source, int dst) {
            this.source = source;
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
        public void addedge(int source, int dst, int wt) {
            edge edge = new edge(source, dst, wt);
            edge redge = new edge(dst, source, wt);
            adjlist[source].add(edge);
            adjlist[dst].add(redge);
        }

        // for unweighted graph//
        public void addedge(int source, int dst) {
            edge edge = new edge(source, dst);
            edge redge = new edge(dst, source);
            adjlist[source].add(edge);
            adjlist[dst].add(redge);
        }

        public void printgraph() {
            for (int i = 0; i < vertices; i++) {
                for (edge e : adjlist[i]) {
                    System.out.println("vertex-" + e.source + " is connected to " + e.dst);
                }
            }

        }

        public void dfs(int src, int dest,boolean [] is_visited) {
            if ( is_visited[src] ) {
                return;
            }
            System.out.println(src);
            is_visited[src] = true;
            for (edge e : adjlist[src]) {
                dfs(e.dst, dest, is_visited);
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
        boolean[] is_visited = new boolean[7];
        for (int i = 0; i < 7; i++) {
            is_visited[i] = false;
        }
        graph.dfs(0, 6, is_visited);

    }

}
