
import java.util.*;

public class bfs_adj_list {

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

        public List<Integer> bfs(int src,int dest) {
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            boolean[] is_visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                is_visited[i] = false;
            }
            ArrayList<Integer> tracker = new ArrayList<>();
            ArrayList<Integer> parent = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                parent.add(-1);
                
            }
            dq.add(src);
            while (!dq.isEmpty()) {
                int a = dq.removeFirst();
                tracker.add(a);
                if (!is_visited[a]) {
                    is_visited[a] = true;
                    for (edge nbr : adjlist[a]) {
                        if (!is_visited[nbr.dst]) {
                            dq.add(nbr.dst);
                            parent.set(nbr.dst, nbr.source);//here index is vertice sand element is position
                        }
                    }
                }
            }

        
        //!-------path printer--------//
            List<Integer> path = new ArrayList<Integer>();
            for(int i = dest; i!=-1; i=parent.get(i)){
                path.add(i);
            }
            
            Collections.reverse(path);
            if(path.get(0)==src) return path;
            else  return Collections.emptyList();
            



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
        System.out.println(graph.bfs(0,6));

    }
}