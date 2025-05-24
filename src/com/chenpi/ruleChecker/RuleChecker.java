package com.chenpi.ruleChecker;

import com.chenpi.board.Board;
import com.chenpi.gameState.GameState;
import com.chenpi.skills.Skill;
import com.chenpi.utils.PieceType;
import com.chenpi.utils.Point;

public class RuleChecker {
  private GameState gameState;
  private Board board;

  public RuleChecker(GameState gameState) {
    this.gameState = gameState;
    this.board = gameState.getBoard();
  }

  public boolean isValidMove(Point point) {
    return this.board.isCellValid(point) && board.isCellEmpty(point);
  }

  public boolean checkWinCondition(Point point) {
    PieceType currentType = gameState.getBoard().getPieceType(point);

    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        if (dx == 0 && dy == 0) continue;

        int count = 1;
        count += countDirection(point, dx, dy, currentType);
        count += countDirection(point, -dx, -dy, currentType);

        if (count >= 5) return true;
      }
    }
    return false;
  }

  private int countDirection(Point start, int dx, int dy, PieceType type) {
    int count = 0;
    int x = start.getX() + dx;
    int y = start.getY() + dy;
    Point next = new Point(x, y);

    while (gameState.getBoard().isCellValid(next)
            && gameState.getBoard().getPieceType(next) == type) {
      count++;
      x += dx;
      y += dy;
      next = new Point(x, y);
    }

    return count;
  }

  //TODO:完成技能类来实现该判断
  public boolean isSkillUseLegal(Skill skill, GameState gameState) {
    return true;
  }
}
