import java.util.*;

public class Djikstra_algo {

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

    static class eComparator implements Comparator<edge> {
        @Override
        public int compare(edge e1, edge e2) {
            if (e1.wt < e2.wt)
                return 1;
            else if (e1.wt < e2.wt)
                return -1;
            return 0;
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

        class eComparator implements Comparator<vertex_dist_pair> {
            @Override
            public int compare(vertex_dist_pair e1, vertex_dist_pair e2) {
                if (e1.distance > e2.distance)
                    return 1;
                else if (e1.distance < e2.distance)
                    return -1;
                return 0;
            }
        }

        class vertex_dist_pair {
            int vertex;
            int distance;

            vertex_dist_pair(int vertex, int distance) {
                this.vertex = vertex;
                this.distance = distance;
            }
        }

        public void DjikstraAlgo(boolean[] is_visited) {

            PriorityQueue<vertex_dist_pair> pq = new PriorityQueue<vertex_dist_pair>(vertices, new eComparator());

            int[] dist_from_start = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                dist_from_start[i] = Integer.MAX_VALUE;
            }
            dist_from_start[0] = 0;
            pq.add(new vertex_dist_pair(0, 0));
            while (!pq.isEmpty()) {
                vertex_dist_pair ele = pq.poll();
                is_visited[ele.vertex] = true;
                for (edge e : adjlist[ele.vertex]) {
                    if (!is_visited[e.dst]) {
                        int updated_distance = dist_from_start[ele.vertex] + e.wt;
                        if (updated_distance < dist_from_start[e.dst]) {
                            dist_from_start[e.dst] = updated_distance;
                            pq.add(new vertex_dist_pair(e.dst, updated_distance));
                        }

                    }
                }

            }
            System.out.println(Arrays.toString(dist_from_start));

        }

    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter number of edges");
        // int v = sc.nextInt();

        int v = 7;
        Graph graph = new Graph(v);
        graph.addedge(0, 1, 1);
        graph.addedge(0, 3, 2);
        graph.addedge(1, 2, 3);
        graph.addedge(3, 4, 4);
        graph.addedge(2, 3, 5);
        graph.addedge(4, 5, 6);
        graph.addedge(4, 6, 7);
        graph.printgraph();
        boolean[] is_visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            is_visited[i] = false;
        }
        graph.DjikstraAlgo(is_visited);

    }

}