import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.print(answer(board));

    }

    private static boolean answer(char[][] board) {

        char[] column = new char[9];
        for (int i = 0; i < board.length; i++) {
            if (!checkRowOrColumn(board[i]))
                return false;

            for (int j = 0; j < board.length; j++) {
                column[j] = board[j][i];
            }
            if (!checkRowOrColumn(column))
                return false;

        }

        for (int i = 0; i < board.length; i += 3) {

            for (int j = 0; j < board.length; j += 3) {

                column[0] = board[i + 0][j + 0];
                column[1] = board[i + 0][j + 1];
                column[2] = board[i + 0][j + 2];
                column[3] = board[i + 1][j + 0];
                column[4] = board[i + 1][j + 1];
                column[5] = board[i + 1][j + 2];
                column[6] = board[i + 2][j + 0];
                column[7] = board[i + 2][j + 1];
                column[8] = board[i + 2][j + 2];

                if (!checkRowOrColumn(column))
                    return false;
            }

        }
        return true;
    }

    private static boolean checkRowOrColumn(char[] list) {

        Set<Character> indexes = new HashSet<>();

        for (int i = 0; i < list.length; i++) {
            if (list[i] != '.') {
                if (list[i] > 48 && list[i] < 58) {
                    if (!indexes.add(list[i]))
                        return false;
                } else
                    return false;

            }
        }

        return true;

    }
}
