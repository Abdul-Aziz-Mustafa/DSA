import java.util.*;

public class cycle_detection_using_dfs_undirected {

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

        public void addedge_directed(int source, int dst) {
            edge edge = new edge(source, dst);
            adjlist[source].add(edge);
        }

        public void printgraph() {
            for (int i = 0; i < vertices; i++) {
                for (edge e : adjlist[i]) {
                    System.out.println("vertex-" + e.source + " is connected to " + e.dst);
                }
            }

        }
        // !----visited node hai but parant nhi hai so it should be in ! //

        public void dfs(int src, boolean[] is_visited, boolean[] is_cycle_visited) {

            is_visited[src] = true;
            is_cycle_visited[src] = true;

            for (edge e : adjlist[src]) {
                if (is_visited[e.dst] && is_cycle_visited[e.dst]) {
                    System.out.println("cycle detected");
                }
                if (!is_cycle_visited[e.dst]) {
                    dfs(e.dst, is_visited, is_cycle_visited);

                }
            }
            is_cycle_visited[src] = false;
        }

    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter number of edges");
        // int v = sc.nextInt();
        int v = 7;
        Graph graph = new Graph(v);
        graph.addedge_directed(0, 1);
        graph.addedge_directed(0, 3);
        graph.addedge_directed(1, 2);
        graph.addedge_directed(3, 4);
        graph.addedge_directed(2, 3);
        graph.addedge_directed(4, 5);
        graph.addedge_directed(4, 6);
        graph.printgraph();
        boolean[] is_visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            is_visited[i] = false;
        }
        boolean[] is_cycle_visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            is_cycle_visited[i] = false;
        }
        graph.dfs(0, is_visited, is_cycle_visited);

    }

}