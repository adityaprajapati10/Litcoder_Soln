import java.util.Scanner;

public class SudokuSolver { // Change this class name to "Main" when you on litcoder

    public static boolean isValid(char[][] board, int row, int column, char num, int n) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == num && i != column) {
                return false;
            }
        }
    
        for (int j = 0; j < n; j++) {
            if (board[j][column] == num && j != row) {
                return false;
            }
        }
    
        int subRowStart = row - row % 3;
        int subColumnStart = column - column % 3;
    
        for (int i = subRowStart; i < subRowStart + 3; i++) {
            for (int j = subColumnStart; j < subColumnStart + 3; j++) {
                if (board[i][j] == num && (i != row || j != column)) {
                    return false;
                }
            }
        }
    
        return true;
    }
    
        static boolean solveSudoku(char[][] board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] != '.') {
                       if(isValid(board, row, col, board[row][col], board.length) == false){
                        return false;
                       }
                    }
                }
            }
            return true;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        if (solveSudoku(board)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}

// Ex : 
// 9
// 6 . . 1 9 5 . . .
// . 9 8 . . . . 6 .
// . . . . . . . . .
// 8 . . . 6 . . . 3
// 4 . . 8 . 3 . . 1
// 7 . . . 2 . . . 6
// . 6 . . . . 2 8 .
// . . . 4 1 9 . . 5
// . . . . 8 . . 7 9     output : - YES
