package com.chenpi.UI.gaming;

import com.chenpi.UI.WinMessage;
import com.chenpi.gameController.GameController;
import com.chenpi.gameState.GameState;
import com.chenpi.utils.PieceType;
import com.chenpi.utils.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class BoardPanel extends JPanel {
  private GameState gameState;
  private GameController gameController;

  public BoardPanel(GameState gameState, GameController gameController) {
    this.gameController = gameController;
    this.gameState = gameState;

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int[] layout = getBoardLayout();
        int LRPadding = layout[0];
        int UDPadding = layout[1];
        int cellSize = layout[2];

        int x = (e.getX() - LRPadding + cellSize / 2) / cellSize;
        int y = (e.getY() - UDPadding + cellSize / 2) / cellSize;
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
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 抗锯齿效果

    int[] layout = getBoardLayout();
    int LRPadding = layout[0];
    int UDPadding = layout[1];
    int cellSize = layout[2];

    g.setColor(new Color(245, 222, 179));
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.BLACK);

    for (int i = 0; i < gameState.getBoard().getHeight(); i++) {
      int y = UDPadding + i * cellSize;
      g.drawLine(LRPadding, y, LRPadding + (gameState.getBoard().getWidth() - 1) * cellSize, y);
    }

    for (int i = 0; i < gameState.getBoard().getWidth(); i++) {
      int x = LRPadding + i * cellSize;
      g.drawLine(x, UDPadding, x, UDPadding + (gameState.getBoard().getHeight() - 1) * cellSize);
    }

    for (int x = 0; x < gameState.getBoard().getWidth(); x++) {
      for (int y = 0; y < gameState.getBoard().getHeight(); y++) {
        Point point = new Point(x, y);
        printPiece(point, g2, layout, cellSize);
      }
    }
  }

  private void printPiece(Point point, Graphics g, int[] layout, int cellSize) {
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
      case GREEN:
        g.setColor(Color.GREEN);
      default:
        return;
    }

    int pieceSize = (int)(cellSize * 0.75);
    int offset = pieceSize / 2;

    g.fillOval(
            layout[0] + point.getX() * cellSize - offset,
            layout[1] + point.getY() * cellSize - offset,
            pieceSize, pieceSize
    );
  }

  private int[] getBoardLayout() {
    int w = getWidth();
    int h = getHeight();
    int rows = gameState.getBoard().getHeight();
    int cols = gameState.getBoard().getWidth();

    int cellSize = Math.min((w - 40) / cols, (h - 40) / rows);
    int LRPadding = (w - cellSize * (cols - 1)) / 2;
    int UDPadding = (h - cellSize * (rows - 1)) / 2;
    return new int[]{LRPadding, UDPadding, cellSize};
  }
}