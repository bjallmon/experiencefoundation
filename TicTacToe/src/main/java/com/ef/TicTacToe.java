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
        String a1 = gameBoard.get(this.convertToCell(1)) != null ? gameBoard.get(this.convertToCell(1)).getPlayerType().toString() : "1";
        String a2 = gameBoard.get(this.convertToCell(2)) != null ? gameBoard.get(this.convertToCell(2)).getPlayerType().toString() : "2";
        String a3 = gameBoard.get(this.convertToCell(3)) != null ? gameBoard.get(this.convertToCell(3)).getPlayerType().toString() : "3";
        String b1 = gameBoard.get(this.convertToCell(4)) != null ? gameBoard.get(this.convertToCell(4)).getPlayerType().toString() : "4";
        String b2 = gameBoard.get(this.convertToCell(5)) != null ? gameBoard.get(this.convertToCell(5)).getPlayerType().toString() : "5";
        String b3 = gameBoard.get(this.convertToCell(6)) != null ? gameBoard.get(this.convertToCell(6)).getPlayerType().toString() : "6";
        String c1 = gameBoard.get(this.convertToCell(7)) != null ? gameBoard.get(this.convertToCell(7)).getPlayerType().toString() : "7";
        String c2 = gameBoard.get(this.convertToCell(8)) != null ? gameBoard.get(this.convertToCell(8)).getPlayerType().toString() : "8";
        String c3 = gameBoard.get(this.convertToCell(9)) != null ? gameBoard.get(this.convertToCell(9)).getPlayerType().toString() : "9";
        
        System.out.println("   " + a1 + "| " + a2 + " |" + a3 +"   ");
        System.out.println("  --|---|--  ");
        System.out.println("   " + b1 + "| " + b2 + " |" + b3 + "   ");
        System.out.println("  --|---|--  ");
        System.out.println("   " + c1 + "| " + c2 + " |" + c3 + "   ");
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

        System.out.println("Welcome to tic tac toe!");
        
        Game game = new Game();
        game.startGame();

        Player currentPlayer = null;
        
        while (!(game.getGameBoard().isWinner()) ) {
            List<Player> players = game.getPlayers();

            System.out.println("Make Your Move!");
            System.out.println("=============");
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
        System.out.println("***************************************************");
        ticTacToe.printGameBoard(game.getGameBoard());
        System.out.println("Player " + currentPlayer.getPlayerType().toString() + " wins!");
        System.out.println("***************************************************");
        System.out.println("\n\n\n\n\n");
    }
}