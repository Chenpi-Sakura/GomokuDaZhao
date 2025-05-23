package com.chenpi.gameState;

import com.chenpi.board.Board;
import com.chenpi.players.Player;
import com.chenpi.utils.Point;

import java.util.*;

public class GameState {
  private Board board;
  private Queue<Player> playerQueue;
  private List<Player> playerList;
  private Map<Point, Player> moveHistory;

  public GameState(Board board, List<Player> players) {
    this.board = board;
    this.playerQueue = new LinkedList<>(players);
    this.playerList = new ArrayList<>(players);
    this.moveHistory = new LinkedHashMap<>();
  }

  public void switchPlayer() {
    Player current = playerQueue.poll();
    playerQueue.offer(current);
  }

  public Player getCurrentPlayer() {
    return playerQueue.peek();
  }

  //TODO:实现技能的特殊效果记录

  public Board getBoard() {
    return board;
  }

  public Player getPlayer(int index) {
    return playerList.get(index);
  }

  public Map<Point, Player> getMoveHistory() {
    return moveHistory;
  }

  public void againReset() {
    playerQueue = new LinkedList<>(playerList);
    board.clearBoard();
    this.moveHistory = new LinkedHashMap<>();
    // TODO: 重置玩家技能状态（如冷却时间归零）
    // TODO: 重置游戏规则检查器（如连招计数器）
  }
}
