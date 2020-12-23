package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = true;
        int[] diagonal = extractDiagonal(board);
        for (int i = 0; i < board.length ; i++) {
            if (diagonal[i] == 1) {
                if (checkHorizontal(board, i) || checkVertical(board, i)) {
                    return rsl;
                }
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int i = row; i < board[row].length ; i++) {
                if (board[row][i] != 1) {
                    result = false;
                    break;
                }
        }
        return result;
    }

    public static boolean checkVertical(int[][] board, int cell) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static int[] extractDiagonal(int[][] board) {
        int[] result = new int[board.length];
        for (int i = 0; i < board.length ; i++) {
            result[i] = board[i][i];
        }
        return result;
    }
}
