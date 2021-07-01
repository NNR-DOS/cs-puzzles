package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {

    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            Coordinate coordinate = (Coordinate) obj;
            return x == coordinate.x && y == coordinate.y;
        }

        @Override
        public String toString() {
            return "{" + this.x + "," + this.y + "}";
        }
    }

    public static class Color {
        public static String open = "0";
        public static String closed = "1";
    }

    public static List<Coordinate> searchMaze(List<List<String>> maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        if (depthFirstSearch(maze, start, end, path)) {
            System.out.println("Reached the end of the maze!");
            return path;
        }
        return null;
    }

    public static boolean depthFirstSearch(List<List<String>> maze, Coordinate currentPosition, Coordinate end, List<Coordinate> path) {
        if (currentPosition.equals(end)) {
            return true;
        }
        if (!isValid(maze, currentPosition)) {
            System.out.println("Attempt failed: invalid position");
            System.out.println();
            return false;
        }
        path.add(currentPosition);
        System.out.println(path);
        System.out.println();
        maze.get(currentPosition.x).set(currentPosition.y, Color.closed);
        printMaze(maze);
        System.out.println();
        int[][] movements = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] pair : movements) {
            System.out.println("We are now at " + currentPosition);
            System.out.println();
            Coordinate nextPosition = new Coordinate(currentPosition.x + pair[0], currentPosition.y + pair[1]);
            System.out.println("Attempting to move to position: " + nextPosition);
            System.out.println();
            if (depthFirstSearch(maze, nextPosition, end, path)) {
                return true;
            }
        }
        if (path.size() - 2 >= 0) {
            System.out.println("Exhausted all possible movement from position " + currentPosition + ". Returning to " + path.get(path.size() - 2));
            System.out.println();
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static boolean isValid(List<List<String>> maze, Coordinate position) {
        return position.x >= 0 &&
                position.x <= maze.size() - 1 &&
                position.y >= 0 &&
                position.y <= maze.get(0).size() - 1 &&
                maze.get(position.x).get(position.y).equals(Color.open);
    }

    public static void printMaze(List<List<String>> maze) {
        for (List<String> strings : maze) {
            for (int j = 0; j < maze.get(0).size(); j++) {
                System.out.print(strings.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int m = 2;
        int n = 2;

        List<List<String>> maze = new ArrayList<>();
        List<Coordinate> possibleStartingPositions = new ArrayList<>();
        List<Coordinate> possibleEndingPositions = new ArrayList<>();
        String[] colors = {"0", "1"};
        Random random = new Random();
        for (int i = 0; i < m; i++) {
            maze.add(new ArrayList<>(m));
            for (int j = 0; j < n; j++) {
                maze.get(i).add(j, colors[random.nextInt(2)]);
            }
        }
        for (int i = 0; i < maze.size(); i++) {
            for (int j = 0; j < maze.get(0).size(); j++) {
                if (maze.get(i).get(j).equals("0")) {
                    possibleStartingPositions.add(new Coordinate(i, j));
                    possibleEndingPositions.add(new Coordinate(i, j));
                }
            }
        }
        printMaze(maze);
        Coordinate start = possibleStartingPositions.get(random.nextInt(possibleStartingPositions.size()));
        Coordinate end = possibleEndingPositions.get(random.nextInt(possibleEndingPositions.size()));
        System.out.println(start);
        System.out.println(end);
        System.out.println();
        System.out.println(searchMaze(maze, start, end));

    }

}
