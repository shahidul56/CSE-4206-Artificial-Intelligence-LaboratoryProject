package TicTacToe;

import needed_algorithms.Algorithms;

import java.util.Scanner;



public class mainfunctionpart {

    private Board board;
    private Scanner sc = new Scanner(System.in);




    private mainfunctionpart() {
        board = new Board();
    }




    private void play () {

        System.out.println("Starting a new game.");

        while (true) {
            printGameStatus();
            playMove();

            if (board.isGameOver()) {
                printWinner();

                if (!tryAgain()) {
                    break;
                }
            }
        }
    }

    /**---------------------------------------------------------------
     * Handle the move to be played, either by the player or the AI.
     * ----------------------------------------------------------------
     */
    private void playMove () {
        if (board.getTurn() == Board.State.X) {
            getPlayerMove();
        } else {
            Algorithms.alphaBetaAdvanced(board);
        }
    }

    /**----------------------------------------------------
     * Print out the board and the player who's turn it is.
     * ----------------------------------------------------
     */
    private void printGameStatus () {
        System.out.println("\n" + board + "\n");
        System.out.println(board.getTurn().name() + "'s turn.");
    }


    private void getPlayerMove () {
        System.out.print("Index of move: ");

        int move = sc.nextInt();

        if (move < 0 || move >= Board.BOARD_WIDTH* Board.BOARD_WIDTH) {
            System.out.println("\nInvalid move.");
            System.out.println("\nThe index of the move must be between 0 and "
                    + (Board.BOARD_WIDTH * Board.BOARD_WIDTH - 1) + ", inclusive.");
        } else if (!board.move(move)) {
            System.out.println("\nInvalid move.");
            System.out.println("\nThe selected index must be blank.");
        }
    }



    private void printWinner () {
        Board.State winner = board.getWinner();

        System.out.println("\n" + board + "\n");

        if (winner == Board.State.Blank) {
            System.out.println("The TicTacToe is a Draw.");
        } else {
            System.out.println("Player " + winner.toString() + " wins!");
        }
    }





    private boolean tryAgain () {
        if (promptTryAgain()) {
            board.reset();
            System.out.println("Started new game.");
            System.out.println("X's turn.");
            return true;
        }

        return false;
    }


    private boolean promptTryAgain () {
        while (true) {
            System.out.print("Would you like to start a new game? (Y/N): ");
            String response = sc.next();
            if (response.equalsIgnoreCase("y")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Invalid input.");
        }
    }

    public static void main(String[] args) {
        mainfunctionpart ticTacToe = new mainfunctionpart();
        ticTacToe.play();
    }

}
