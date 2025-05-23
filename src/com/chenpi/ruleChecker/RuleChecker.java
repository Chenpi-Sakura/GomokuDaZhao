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
    int horizontal = 1, vertical = 1, mainDiagonal = 1, antiDiagonal = 1;
    PieceType type = this.board.getPieceType(point);

    // HorizontalCheck
    for (int i = point.getX() + 1;; i++) {
      Point point1 = new Point(i, point.getY());
      if (this.board.getPieceType(point1) == type) {
        horizontal++;
      }
      else {
        break;
      }
    }
    for (int i = point.getX() - 1;; i--) {
      Point point1 = new Point(i, point.getY());
      if (this.board.getPieceType(point1) == type) {
        horizontal++;
      }
      else {
        break;
      }
    }
    if (horizontal >= 5) {
      return true;
    }

    // VerticalCheck
    for (int i = point.getY() + 1;; i++) {
      Point point1 = new Point(point.getX(), i);
      if (this.board.getPieceType(point1) == type) {
        vertical++;
      }
      else {
        break;
      }
    }
    for (int i = point.getY() - 1;; i--) {
      Point point1 = new Point(point.getX(), i);
      if (this.board.getPieceType(point1) == type) {
        vertical++;
      }
      else {
        break;
      }
    }
    if (vertical >= 5) {
      return true;
    }

    // MainDiagonalCheck
    for (int i = 1;; i++) {
      Point point1 = new Point(point.getX() + i, point.getY() + i);
      if (this.board.getPieceType(point1) == type) {
        mainDiagonal++;
      }
      else {
        break;
      }
    }
    for (int i = -1;; i--) {
      Point point1 = new Point(point.getX() + i, point.getY() + i);
      if (this.board.getPieceType(point1) == type) {
        mainDiagonal++;
      }
      else {
        break;
      }
    }
    if (mainDiagonal >= 5) {
      return true;
    }

    // AntiDiagonalCheck
    for (int i = 1;; i++) {
      Point point1 = new Point(point.getX() + i, point.getY() - i);
      if (this.board.getPieceType(point1) == type) {
        antiDiagonal++;
      }
      else {
        break;
      }
    }
    for (int i = -1;; i--) {
      Point point1 = new Point(point.getX() + i, point.getY() - i);
      if (this.board.getPieceType(point1) == type) {
        antiDiagonal++;
      }
      else {
        break;
      }
    }
    return antiDiagonal >= 5;
  }

  //TODO:完成技能类来实现该判断
  public boolean isSkillUseLegal(Skill skill, GameState gameState) {
    return true;
  }
}
