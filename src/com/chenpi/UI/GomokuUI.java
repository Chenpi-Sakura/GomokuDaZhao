package com.chenpi.UI;

import com.chenpi.gameController.GameController;
import com.chenpi.gameState.GameState;

import javax.swing.*;

public class GomokuUI extends JFrame {
    private static final int PADDING = 40;
    private static final int CELL_SIZE = 40;

    public GomokuUI(GameState gameState, GameController gameController) {
        setTitle("五子棋大招版");
        setSize(gameState.getBoard().getWidth() * CELL_SIZE + 2 * PADDING, gameState.getBoard().getHeight() * CELL_SIZE + 2 * PADDING);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(new BoardPanel(gameState, gameController));
        setVisible(true);
    }
}