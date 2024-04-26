package lab04_25;

import java.util.Arrays;
import java.util.Stack;

public class Graph {
    private Edge[] graph; // adjacency list for this graph
    private int timeCounter = 0;

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    /**
     * DFS implementation
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited, and false otherwise
     * @param discovery array of "discovery" times when each vertex is visited
     * @param finish  array of "finish" times (when we are done with each vertex because we explored all of its neighbors)
     */
    public void dfs(int vertex, boolean[] visited, int[] discovery, int[] finish) {
        // FILL IN CODE: update discovery and finish times
        visited[vertex] = true;
        Edge curr = graph[vertex];
        while (curr != null) {
            if (!visited[curr.neighbor]) {
                dfs(curr.neighbor, visited, discovery, finish);
            }
            curr = curr.next;
        }
    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        // Discovery and finish times
        // Discovery: when we visit the vertex
        // Finish time: when we are "done" with the vertex (no more neighbors to explore)
        int discovery[]  = new int[graph.length];
        int finish[]  = new int[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited, discovery, finish);
        }
        for (int i = 0; i < discovery.length; i++) {
            System.out.println(i + ", d: " + discovery[i] + " f: " + finish[i]);
        }
    }


    /** Runs a bfs helper method. Implemented using a queue */
    public void bfs(int vertex, boolean visited[]) {
        Queue queue = new ArrayQueue();
        queue.enqueue(vertex);
        visited[vertex] = true;
        System.out.println(vertex);
        while (!queue.empty()) {
            // Run BFS - dequeue, enqueue unvisited neighbors (where will you mark as visited and print?)

        }  // white queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge56);
        g.addEdge(5, edge54);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);
        g.dfsMain();
        // g.bfsMain();
    }
}

