import java.util.*;

public class task1{

    public  boolean isBipartite(int[][] graph) {
    int n = graph.length; // number of nodes in the graph
    int colors[] = new int[n]; // array to store the color of each node

    //assigning values to the color array as -1
    for (int i = 0; i < n; i++){
        colors[i] = -1;      
    }
                                    

    Arrays.fill(colors, -1); 
    // initially all nodes are uncolored

    for (int start = 0; start < n; start++) { 
        // iterate through all uncolored nodes

        if (colors[start] == -1) { 
            // if the node is uncolored

            Queue<Integer> queue = new LinkedList<>(); 
            // use a queue for BFS
            queue.add(start); 
            // add the node to the queue
            colors[start] = 0; 
            // assign color 0 to the node
            
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor = 0; neighbor < n; neighbor++) {
                    if (graph[node][neighbor] == 1 && colors[neighbor] == -1) { 
                        // if the neighbor is uncolored
                        queue.add(neighbor); 
                        // add the neighbor to the queue
                        colors[neighbor] = 1 - colors[node]; 
                        // assign the opposite color of the current node to the neighbor
                    } else if (graph[node][neighbor] == 1 && colors[neighbor] == colors[node]) {
                        return false; 
                        // if the neighbor is colored and has the same color as the current node, the graph is not bipartite
                    }
                }
            }
        }
    }
    return true; // if all nodes are visited and colored without conflicts, the graph is bipartite
}
    public static void main(String args[]){

        int[][] bipartiteGraph   = {{0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 1, 0}};
        int[][] nonBipartiteGraph = {{0, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 0}};

        task1 a = new task1();
        task1 b = new task1();


        System.out.println(a.isBipartite(bipartiteGraph)); // prints "true"
        System.out.println(b.isBipartite(nonBipartiteGraph)); // prints "false"

        
    }
}
