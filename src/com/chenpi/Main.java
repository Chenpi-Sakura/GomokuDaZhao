package com.chenpi;

import com.chenpi.UI.GomokuUI;
import com.chenpi.board.Board;
import com.chenpi.gameController.GameController;
import com.chenpi.gameState.GameState;
import com.chenpi.players.Player;
import com.chenpi.utils.PieceType;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Board board = new Board(15, 15);

    Player player1 = new Player("Player 1", 1, PieceType.RED);
    Player player2 = new Player("Player 2", 1, PieceType.BLUE);

    List<Player> players = Arrays.asList(player1, player2);

    GameState gameState = new GameState(board, players);
    GameController gameController = new GameController(gameState);

    SwingUtilities.invokeLater(() -> new GomokuUI(gameState, gameController));
  }
}
