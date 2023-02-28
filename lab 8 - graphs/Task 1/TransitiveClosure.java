
import java.util.ArrayList;
import java.util.List;

public class TransitiveClosure {
    private int V; // number of vertices
    private boolean[][] tc; // transitive closure matrix
    private List<Integer>[] adj; // adjacency list representation of the graph

    public TransitiveClosure(int v) {
        V = v;
        tc = new boolean[V][V];
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS traversal of the vertices reachable from v
    private void DFS(int v, int u) {
        tc[v][u] = true;
        for (int i = 0; i < adj[u].size(); i++) {
            if (!tc[v][adj[u].get(i)]) {
                DFS(v, adj[u].get(i));
            }
        }
    }

    // function to get transitive closure
    public void getTransitiveClosure() {
        for (int i = 0; i < V; i++) {
            DFS(i, i);
        }
    }

    // prints the transitive closure matrix
    public void printTC() {
        System.out.println("Transitive closure matrix is: ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){

       TransitiveClosure g = new TransitiveClosure(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.getTransitiveClosure();
        g.printTC();

    }
}
