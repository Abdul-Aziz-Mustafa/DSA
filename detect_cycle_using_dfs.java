import java.util.*;

public class detect_cycle_using_dfs {

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
        // !----visited node hai but parant nhi hai so it should be in
        // cycle-----------!//

        public void dfs(int src, boolean[] is_visited, int parent) {

            is_visited[src] = true;

            for (edge e : adjlist[src]) {
                if (is_visited[e.dst] && e.dst != parent && parent != -1) {
                    System.out.println("Brian that should be a cycle");
                } else if (!is_visited[e.dst]) {
                    dfs(e.dst, is_visited, e.source);

                }
            }
        }

    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter number of edges");
        // int v = sc.nextInt();
        Graph graph = new Graph(8);
        graph.addedge(0, 1);
        graph.addedge(0, 3);
        graph.addedge(1, 2);
        graph.addedge(3, 4);
        graph.addedge(2, 3);
        graph.addedge(4, 5);
        graph.addedge(4, 6);
        graph.printgraph();
        boolean[] is_visited = new boolean[8];
        for (int i = 0; i < 8; i++) {
            is_visited[i] = false;
        }

        graph.dfs(0, is_visited, -1);

    }

}
