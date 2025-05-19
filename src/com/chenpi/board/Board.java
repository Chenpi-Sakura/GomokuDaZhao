package com.chenpi.board;

import com.chenpi.utils.PieceType;
import com.chenpi.utils.Point;

public class Board {
  private int width;
  private int height;
  private PieceType[][] grid;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        grid[i][j] = PieceType.NONE;
      }
    }
  }

  public boolean isCellEmpty(Point point) {
    return grid[point.getX()][point.getY()] == PieceType.NONE;
  }

  public void placePiece(Point point, PieceType pieceType){
    grid[point.getX()][point.getY()] = pieceType;
  }

  public boolean removePiece(Point point) {
    if (!isCellEmpty(point)) {
      grid[point.getX()][point.getY()] = PieceType.NONE;
      return true;
    }
    else {
      return false;
    }
  }

  public PieceType getPieceType(Point point) {
    return grid[point.getX()][point.getY()];
  }

  public boolean isCellValid(Point point) {
    return point.getX() < width && point.getY() < height;
  }
}
