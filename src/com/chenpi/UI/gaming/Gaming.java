package com.chenpi.UI.gaming;

import com.chenpi.gameController.GameController;
import com.chenpi.gameState.GameState;

import javax.swing.*;
import java.awt.*;

public class Gaming extends JFrame{
  public Gaming(GameState gameState, GameController gameController) {
    setTitle("五子棋大招版");
    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);

    setLayout(new BorderLayout());
    BoardPanel boardPanel = new BoardPanel(gameState, gameController);
    add(boardPanel, BorderLayout.CENTER);

    setLocationRelativeTo(null);
    setVisible(true);
  }
}
