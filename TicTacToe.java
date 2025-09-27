import java.util.Scanner;
public class TicTacToe {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static char current = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int turn = 0; turn < 9; turn++) {
            printBoard();
            System.out.print("Player " + current + ", enter position (1-9): ");
            int move = sc.nextInt() - 1;

            if (move < 0 || move > 8 || board[move] != ' ') {
                System.out.println("Invalid move, try again.");
                turn--;
                continue;
            }

            board[move] = current;

            if (checkWinner()) {
                printBoard();
                System.out.println("🎉 Player " + current + " wins!");
                return;
            }

            current = (current == 'X') ? 'O' : 'X';
        }
        printBoard();
        System.out.println("It's a draw!");
        sc.close();
    }

    static void printBoard() {
        for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i] + " | " + board[i+1] + " | " + board[i+2]);
            if (i < 6) System.out.println("--+---+--");
        }
    }

    static boolean checkWinner() {
        int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8}, // rows
            {0,3,6},{1,4,7},{2,5,8}, // cols
            {0,4,8},{2,4,6}          // diagonals
        };
        for (int[] pos : winPositions) {
            if (board[pos[0]] != ' ' && 
                board[pos[0]] == board[pos[1]] && 
                board[pos[1]] == board[pos[2]]) {
                return true;
            }
        }
        return false;
    }
}
