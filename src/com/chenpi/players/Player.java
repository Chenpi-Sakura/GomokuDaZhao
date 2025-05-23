package com.chenpi.players;

import com.chenpi.utils.PieceType;

public class Player {
  private String name;
  private int id;
  private PieceType pieceType;

  public Player(String name, int id, PieceType pieceType) {
    this.name = name;
    this.id = id;
    this.pieceType = pieceType;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public PieceType getPieceType() {
    return pieceType;
  }
}
