package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WordSearch {

    public static class Coordinate {
        int row, column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row &&
                    column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }


    public static boolean exist(char[][] board, String word) {

        List<Coordinate> possibleStartingCoordinates = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    possibleStartingCoordinates.add(new Coordinate(i, j));
                }
            }
        }

        for (Coordinate start : possibleStartingCoordinates) {
            char[][] boardClone = new char[board.length][];
            for (int i = 0; i < board.length; i++)
                boardClone[i] = board[i].clone();
            List<Coordinate> path = new ArrayList<>();
            if (search(boardClone, word, start, path)) {
                return true;
            }
        }

        return false;
    }

    public static boolean search(char[][] board, String word, Coordinate currentPosition, List<Coordinate> path) {

        char initialLetterValue;

        char closed = 'C';

        if (!validPosition(board, currentPosition, word)) {
            return false;
        } else {
            initialLetterValue = board[currentPosition.row][currentPosition.column];
        }

        if (board[currentPosition.row][currentPosition.column] == word.charAt(0) && word.length() == 1) {
            return true;
        }

        board[currentPosition.row][currentPosition.column] = closed;

        path.add(currentPosition);

        final int[][] SHIFT = {
                {0, 1},  //right
                {1, 0},  //down
                {0, -1}, //left
                {-1, 0}  //up
        };

        for (int[] ints : SHIFT) {
            int tempRowPosition = currentPosition.row;
            int tempColumnPosition = currentPosition.column;
            if (search(board, word.substring(1), new Coordinate(tempRowPosition + ints[0], tempColumnPosition + ints[1]), path)) {
                return true;
            }
        }

        board[currentPosition.row][currentPosition.column] = initialLetterValue;

        path.remove(path.size() - 1);

        return false;
    }

    public static boolean validPosition(char[][] board, Coordinate currentPosition, String word) {
        return currentPosition.row >= 0 &&
                currentPosition.row < board.length &&
                currentPosition.column >= 0 &&
                currentPosition.column < board[0].length &&
                board[currentPosition.row][currentPosition.column] == word.charAt(0);
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        System.out.println(exist(board, "ABCEFSADEESE"));
    }
}
