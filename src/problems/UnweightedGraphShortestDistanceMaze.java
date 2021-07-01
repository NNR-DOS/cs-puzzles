package problems;

import java.util.LinkedList;
import java.util.Queue;

public class UnweightedGraphShortestDistanceMaze {
    int ROW = 9;
    int COL = 10;

    // To store matrix cell cordinates
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // A Data Structure for queue used in BFS
    static class queueNode {
        Point coordinate; // The cordinates of a cell
        int distanceFromStart; // cell's distance from the start

        public queueNode(Point coordinate, int distanceFromStart) {
            this.coordinate = coordinate;
            this.distanceFromStart = distanceFromStart;
        }
    }

    // check whether given cell (row, col)
    // is a valid cell or not.
    boolean isValid(int row, int col) {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    // These arrays are used to get row and column
    // numbers of 4 neighbours of a given cell
    int[] rowNum = {-1, 0, 0, 1};
    int[] colNum = {0, -1, 1, 0};

    // function to find the shortest path between
    // a given start cell to a destination cell.
    int BFS(int[][] maze, Point start,
                   Point end) {
        // check start and destination cell
        // of the matrix have value 1
        if (maze[start.x][start.y] != 1 ||
                maze[end.x][end.y] != 1)
            return -1;

        boolean[][] visited = new boolean[ROW][COL];

        // Mark the start cell as visited
        visited[start.x][start.y] = true;

        // Create a queue for BFS
        Queue<queueNode> q = new LinkedList<>();

        // Distance of start cell is 0
        queueNode s = new queueNode(start, 0);
        q.add(s); // Enqueue start cell

        // Do a BFS starting from start cell
        while (!q.isEmpty()) {
            queueNode currentNode = q.peek();
            Point coordinate = currentNode.coordinate;

            // If we have reached the destination cell,
            // we are done
            if (coordinate.x == end.x && coordinate.y == end.y)
                return currentNode.distanceFromStart;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove();

            for (int i = 0; i < 4; i++) {
                int row = coordinate.x + rowNum[i];
                int col = coordinate.y + colNum[i];

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col) &&
                        maze[row][col] == 1 &&
                        !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode adjacentNode = new queueNode(new Point(row, col),
                            currentNode.distanceFromStart + 1);
                    q.add(adjacentNode);
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1;
    }

    // Driver Code
    public void main(String[] args) {
        int[][] maze = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        Point start = new Point(0, 0);
        Point end = new Point(3, 4);

        int distanceFromStart = BFS(maze, start, end);

        if (distanceFromStart != Integer.MAX_VALUE)
            System.out.println("Shortest Path is " + distanceFromStart);
        else
            System.out.println("Shortest Path doesn't exist");
    }
}
