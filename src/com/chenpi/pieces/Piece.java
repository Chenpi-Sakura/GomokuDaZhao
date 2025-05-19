package com.chenpi.pieces;

import com.chenpi.players.Player;
import com.chenpi.utils.PieceType;

public class Piece {
  private Player owner;
  private PieceType type;

  public Piece(Player owner, PieceType type) {
    this.owner = owner;
    this.type = type;
  }

  public Player getOwner() {
    return owner;
  }

  public PieceType getType() {
    return type;
  }
}
