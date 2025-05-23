package com.chenpi.gameController;

import com.chenpi.gameState.GameState;
import com.chenpi.ruleChecker.RuleChecker;
import com.chenpi.utils.PieceType;
import com.chenpi.utils.Point;

public class GameController {
  private GameState gameState;
  private RuleChecker ruleChecker;

  public GameController(GameState gameState) {
    this.gameState = gameState;
    this.ruleChecker = new RuleChecker(gameState);
  }

  public boolean placePiece(Point point) {
    if (gameState.getBoard().isCellValid(point) && gameState.getBoard().isCellEmpty(point)) {
      PieceType type = gameState.getCurrentPlayer().getPieceType();
      gameState.getBoard().placePiece(point, type);
      if (ruleChecker.checkWinCondition(point)) {
        return true;
      }
      else {
        switchPlayer();
      }
    }
    return false;
  }

  public void switchPlayer() {
    gameState.switchPlayer();
  }

  public void againReset() {
    gameState.againReset();
  }
}
