package com.chenpi.ruleChecker;

import com.chenpi.board.Board;
import com.chenpi.utils.Point;

public class RuleChecker {
  public static boolean isValidMove(Point point, Board board) {
    return board.isCellValid(point);
  }

  public static boolean checkWinCondition(Point point, Board board) {
    int horizontal = 1, vertical = 1, mainDiagonal = 1, antiDiagonal = 1;
    for (int i = point.getX();; i++) {
      Point point1 = new Point(i, point.getY());

    }
  }
}
