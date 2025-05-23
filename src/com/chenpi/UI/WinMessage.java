package com.chenpi.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WinMessage extends JDialog {
  public WinMessage(JFrame parent, String winnerName, Runnable onRestart) {
    super(parent, "Games Over", true);

    JLabel label = new JLabel(winnerName + " Wins!", SwingConstants.CENTER);

    JButton restartButton = new JButton("Again");
    JButton exitButton = new JButton("Exit");

    restartButton.addActionListener((ActionEvent e) -> {
      dispose();
      if (onRestart != null) onRestart.run();
    });

    exitButton.addActionListener((ActionEvent e) -> System.exit(0));

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(restartButton);
    buttonPanel.add(exitButton);

    setLayout(new BorderLayout());
    add(label, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    setSize(250, 120);
    setLocationRelativeTo(parent);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
}
