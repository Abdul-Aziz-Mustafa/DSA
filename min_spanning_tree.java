import java.util.*;

public class min_spanning_tree {

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

        class eComparator implements Comparator<edge> {
            @Override
            public int compare(edge e1, edge e2) {
                if (e1.wt > e2.wt)
                    return 1;
                else if (e1.wt < e2.wt)
                    return -1;
                return 0;
            }
        }

        public void primsAlgo(boolean[] is_visited) {
            int edgecount = 0, mstEdgecost = 0;
            ArrayList<edge> mstEdge = new ArrayList<>();
            PriorityQueue<edge> pq = new PriorityQueue<edge>(vertices, new eComparator());
            for (edge e : adjlist[0]) {
                pq.add(e);
            }
            while (!pq.isEmpty() && edgecount != vertices - 1) {
                edge e = pq.poll();

                int d = e.dst;
                if (is_visited[d]) {

                    continue;

                }
                is_visited[e.source] = true;

                System.out.println(d);

                for (edge ed : adjlist[d]) {
                    if (!is_visited[ed.dst]) {
                        pq.add(ed);
                    }
                }
                mstEdge.add(e);

                mstEdgecost += e.wt;
                edgecount++;
            }
            for (int i = 0; i < is_visited.length-1; i++) {
                System.out.println(mstEdge.get(i).wt + "lol");
            }

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
        graph.addedge(0, 2, 11);
        graph.addedge(3, 4, 4);
        graph.addedge(2, 3, 5);
        graph.addedge(4, 5, 66);
        graph.addedge(4, 6, 7);
        graph.printgraph();
        boolean[] is_visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            is_visited[i] = false;
        }
        graph.primsAlgo(is_visited);

    }

}