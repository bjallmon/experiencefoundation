package com.ef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {
    private static List<Cell> possibleMoves = new ArrayList<Cell>(Arrays.asList(Cell.values()));
    
    public static int inputToInt(String input ){
        int index = -1;
        
        try{
            index = Integer.valueOf(input.trim()).intValue();
        } catch(Exception ex) {
            System.out.println("Invalid move!");
        }
        
        return index;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toe!");
        
        System.out.print("Enter 1 to start a new game: ");
        
        String startOrExit = System.console().readLine();
        
        if("1".equals(startOrExit)) {
            Game game = new Game();
            game.startGame();
            
            List<Player> players = game.getPlayers();
            
            System.out.println("   1| 2 |3   ");
            System.out.println("  --|---|--  ");
            System.out.println("   4| 5 |6   ");
            System.out.println("  --|---|--  ");
            System.out.println("   7| 8 |9   ");
            
            int move = -1;
            
            while(move <= 0 || move > 9) {
                System.out.print("Player 1 enter move: ");
                String input = System.console().readLine();
                
                move = TicTacToe.inputToInt(input);
            }
            
            game.move(TicTacToe.possibleMoves.remove(--move), players.get(0));
            
            System.out.println(game.getGameBoard());
        } else {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }

}
