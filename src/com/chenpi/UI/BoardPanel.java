package com.chenpi.UI;

import com.chenpi.gameController.GameController;
import com.chenpi.gameState.GameState;
import com.chenpi.utils.PieceType;
import com.chenpi.utils.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class BoardPanel extends JPanel {
  private static final int PADDING = 40;
  private static final int CELL_SIZE = 40;

  private GameState gameState;
  private GameController gameController;

  public BoardPanel(GameState gameState, GameController gameController) {
    this.gameController = gameController;
    this.gameState = gameState;

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = (e.getX() - PADDING + CELL_SIZE / 2) / CELL_SIZE;
        int y = (e.getY() - PADDING + CELL_SIZE / 2) / CELL_SIZE;
        Point point = new Point(x, y);

        boolean win = BoardPanel.this.gameController.placePiece(point);
        BoardPanel.this.repaint();

        if (win) {
          SwingUtilities.invokeLater(() -> {
            new WinMessage(
                    (JFrame) SwingUtilities.getWindowAncestor(BoardPanel.this),
                    gameState.getCurrentPlayer().getName(),
                    () -> {
                      gameController.againReset();
                      BoardPanel.this.repaint();
                    }
            ).setVisible(true);
          });
        }
        BoardPanel.this.repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(245, 222, 179));
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.BLACK);

    for (int i = 0; i < gameState.getBoard().getHeight(); i++) {
      int y = PADDING + i * CELL_SIZE;
      g.drawLine(PADDING, y, PADDING + (gameState.getBoard().getWidth() - 1) * CELL_SIZE, y);
    }

    for (int i = 0; i < gameState.getBoard().getWidth(); i++) {
      int x = PADDING + i * CELL_SIZE;
      g.drawLine(x, PADDING, x, PADDING + (gameState.getBoard().getHeight() - 1) * CELL_SIZE);
    }

    for (int x = 0; x < gameState.getBoard().getWidth(); x++) {
      for (int y = 0; y < gameState.getBoard().getHeight(); y++) {
        Point point = new Point(x, y);
        printPiece(point, g);
      }
    }
  }

  private void printPiece(Point point, Graphics g) {
    PieceType type = gameState.getBoard().getPieceType(point);
    switch (type) {
      case RED:
        g.setColor(Color.RED);
        break;
      case YELLOW:
        g.setColor(Color.YELLOW);
        break;
      case BLUE:
        g.setColor(Color.BLUE);
        break;
      default:
        return;
    }
    g.fillOval(PADDING + point.getX() * CELL_SIZE - 15, PADDING + point.getY() * CELL_SIZE - 15, 30, 30);
  }
}