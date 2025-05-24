package com.chenpi.UI;

import com.chenpi.UI.gaming.Gaming;
import com.chenpi.gameController.GameController;
import com.chenpi.gameState.GameState;

import javax.swing.*;

public class GomokuUI extends JFrame {
  public GomokuUI(GameState gameState, GameController gameController) {
    new Gaming(gameState, gameController);
  }
}