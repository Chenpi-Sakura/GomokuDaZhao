package com.chenpi.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WinMessage extends JDialog {
  public WinMessage(JFrame parent, String winnerName, Runnable onRestart) {
    super(parent, "Games Over", true);

    JLabel label = new JLabel(winnerName + " Wins!", SwingConstants.CENTER);

    JButton restartButton = new JButton("Again");
    JButton menuButton = new JButton("MainMenu");
    JButton exitButton = new JButton("Exit");

    restartButton.addActionListener((ActionEvent e) -> {
      dispose();
      onRestart.run();
    });

//    menuButton,addMouseListener();

    exitButton.addActionListener((ActionEvent e) -> System.exit(0));

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(restartButton);
    buttonPanel.add(menuButton);
    buttonPanel.add(exitButton);

    setLayout(new BorderLayout());
    add(label, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    setSize(300, 120);
    setLocationRelativeTo(parent);
  }
}
