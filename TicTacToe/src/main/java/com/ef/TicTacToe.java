package com.ef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToe {

    private static Map<Integer, Cell> cells = new HashMap<Integer,Cell>(){{
        put(new Integer(1), Cell.A1);
        put(new Integer(2), Cell.A2);
        put(new Integer(3), Cell.A3);
        put(new Integer(4), Cell.B1);
        put(new Integer(5), Cell.B2);   
        put(new Integer(6), Cell.B3);
        put(new Integer(7), Cell.C1);
        put(new Integer(8), Cell.C2);
        put(new Integer(9), Cell.C3);
    }};
    
    public static int inputToInt(String input) {
        int index = -1;

        try {
            index = Integer.valueOf(input.trim()).intValue();
        } catch (Exception ex) {
            System.out.println("Invalid move!");
        }

        return index;
    }

    public void printGameBoard(GameBoard<Cell,Player> gameBoard) {
        String a1 = gameBoard.get(this.convertToCell(1)) != null ? gameBoard.get(this.convertToCell(1)).getPlayerType().toString() : " ";
        String a2 = gameBoard.get(this.convertToCell(2)) != null ? gameBoard.get(this.convertToCell(2)).getPlayerType().toString() : " ";
        String a3 = gameBoard.get(this.convertToCell(3)) != null ? gameBoard.get(this.convertToCell(3)).getPlayerType().toString() : " ";
        String b1 = gameBoard.get(this.convertToCell(4)) != null ? gameBoard.get(this.convertToCell(4)).getPlayerType().toString() : " ";
        String b2 = gameBoard.get(this.convertToCell(5)) != null ? gameBoard.get(this.convertToCell(5)).getPlayerType().toString() : " ";
        String b3 = gameBoard.get(this.convertToCell(6)) != null ? gameBoard.get(this.convertToCell(6)).getPlayerType().toString() : " ";
        String c1 = gameBoard.get(this.convertToCell(7)) != null ? gameBoard.get(this.convertToCell(7)).getPlayerType().toString() : " ";
        String c2 = gameBoard.get(this.convertToCell(8)) != null ? gameBoard.get(this.convertToCell(8)).getPlayerType().toString() : " ";
        String c3 = gameBoard.get(this.convertToCell(9)) != null ? gameBoard.get(this.convertToCell(9)).getPlayerType().toString() : " ";

        System.out.println("\n           Choose a number!      LIVE BOARD!");
        System.out.println("        ------------------------------------------");
        System.out.println("              1 | 2 | 3   " + "        " + a1 + " | " + a2 + " | " + a3 +"   ");
        System.out.println("             ---|---|---  " + "       ---|---|---  ");
        System.out.println("              4 | 5 | 6   " + "        " + b1 + " | " + b2 + " | " + b3 + "   ");
        System.out.println("             ---|---|--   " + "       ---|---|---  ");
        System.out.println("              7 | 8 | 9   " + "        " + c1 + " | " + c2 + " | " + c3 + "   \n");

    }
    
    public Cell convertToCell(int convert) {
        return cells.get(Integer.valueOf(convert));
    }

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        int whoseTurnIsIt = 0;
        
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("");
        System.out.println("    |=====================================================|");
        System.out.println("    ||                                                   ||");
        System.out.println("    ||    W e l c o m e    t o    T i c T a c T o e !    ||");
        System.out.println("    ||                                                   ||");
        System.out.println("    |=====================================================|");
        System.out.println("");

        Game game = new Game();
        game.startGame();

        Player currentPlayer = null;
        
        while (!(game.getGameBoard().isWinner()) ) {
            List<Player> players = game.getPlayers();

            ticTacToe.printGameBoard(game.getGameBoard());

            int move = -1;

            currentPlayer = players.get((whoseTurnIsIt++%2));
            
            while (move < 0 || move > 9) {
                System.out.print("Player ");
                System.out.print(currentPlayer.getPlayerType().toString());
                System.out.print(" enter move: ");
                
                String input = System.console().readLine();

                move = TicTacToe.inputToInt(input);
                
                if(move >= 1 && move <= 9) {
                    boolean didMove = game.move(ticTacToe.convertToCell(move), currentPlayer);
                    
                    if(!didMove) {
                        move = -1;
                    }
                }
            }
        }
        
        System.out.println("\n\n\n");
        System.out.println("     ***************************************************");
        ticTacToe.printGameBoard(game.getGameBoard());
        System.out.println("\n              P l a y e r    " + currentPlayer.getPlayerType().toString() + "    w i n s ! \n");
        System.out.println("     ***************************************************");
        System.out.println("\n\n\n\n\n");
    }
}