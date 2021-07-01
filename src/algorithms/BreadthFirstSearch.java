package algorithms;

import java.util.*;

public class BreadthFirstSearch {

    public static class Graph {
        int size;
        List<List<Integer>> adjacencyList;

        public Graph(int size) {
            this.size = size;
            this.adjacencyList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                this.adjacencyList.add(new ArrayList<>(size));
            }
        }

        public void addEdge(int first, int second) {
            this.adjacencyList.get(first).add(second);
            this.adjacencyList.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[this.size];
            Arrays.fill(distances, -1);
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            distances[startId] = 0;
            visited.add(startId);
            queue.offer(startId);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int adjacentNode : this.adjacencyList.get(current)) {
                    if (!visited.contains(adjacentNode)) {
                        distances[adjacentNode] = 6 + distances[current];
                        visited.add(adjacentNode);
                        queue.offer(adjacentNode);
                    }
                }
            }
            return distances;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
