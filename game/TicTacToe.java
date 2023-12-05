
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public TicTacToe() {
        this.board = new Board();
        this.players = new Player[2];
        players[0] = new Player('X');
        players[1] = new Player('O');
        this.currentPlayerIndex = new Random().nextInt(2);
    }

    public void showBoard() {
        board.display();
    }

    public void showInstructions() {
        System.out.println("Tic-Tac-Toe Instructions...");
        System.out.println("Choose a cell numbered from 1 to 9 as below and play:");
        System.out.println("\t1 | 2 | 3");
        System.out.println("\t---------");
        System.out.println("\t4 | 5 | 6");
        System.out.println("\t---------");
        System.out.println("\t7 | 8 | 9");
        System.out.println("Let's start!");
    }

    public void initialise() {
        board.clear();
        currentPlayerIndex = new Random().nextInt(2);
    }

    public void declareWinner(Player player) {
        System.out.println(player.getSymbol() + " has won!");
    }

    public boolean isGameOver() {
        return board.hasWinner() || board.isFull();
    }

    public void playTicTacToe() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver()) {
            Player currentPlayer = players[currentPlayerIndex];

            // Display the board and player's turn
            showBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn.");

            // Make a move
            boolean validMove = false;
            while (!validMove) {
                System.out.print("Enter your move (1-9): ");
                int move = scanner.nextInt();
                validMove = board.makeMove(currentPlayer, move);
                if (!validMove) {
                    System.out.println("Invalid move. Try again.");
                }
            }

            // Check for a winner
            if (board.hasWinner()) {
                showBoard();
                declareWinner(currentPlayer);
                break;
            }

            // Check for a draw
            if (board.isFull()) {
                showBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch to the next player
            currentPlayerIndex = 1 - currentPlayerIndex;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.showInstructions();

        while (true) {
            game.initialise();
            game.playTicTacToe();


            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to play again? (yes/no): ");

            // Check if there is input available
            if (scanner.hasNextLine()) {
                String playAgain = scanner.nextLine().toLowerCase();
                if (!playAgain.equals("yes")) {
                    System.out.println("Thanks for playing. Goodbye!");
                    break;
                }
            } else {
                System.out.println("Invalid input. Exiting the game.");
                break;
            }

        }
    }
}

class Board {
    private char[][] state;

    public Board() {
        this.state = new char[3][3];
        clear();
    }

    public void display() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                state[i][j] = ' ';
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (state[i][0] == state[i][1] && state[i][1] == state[i][2] && state[i][0] != ' ') {
                return true; // Row win
            }
            if (state[0][i] == state[1][i] && state[1][i] == state[2][i] && state[0][i] != ' ') {
                return true; // Column win
            }
        }
        if (state[0][0] == state[1][1] && state[1][1] == state[2][2] && state[0][0] != ' ') {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (state[0][2] == state[1][1] && state[1][1] == state[2][0] && state[0][2] != ' ') {
            return true; // Diagonal win (top-right to bottom-left)
        }
        return false;
    }

    public boolean makeMove(Player player, int position) {
        // Check if the move is valid and update the board
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && state[row][col] == ' ') {
            state[row][col] = player.getSymbol();
            return true; // Valid move
        }
        return false; // Invalid move
    }
}

class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

