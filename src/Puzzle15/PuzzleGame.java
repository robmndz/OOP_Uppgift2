package Puzzle15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleGame implements ActionListener {

    JFrame frame;
    JButton startButton;
    JPanel panel;
    int indexEmptyButton = 15;
    JButton[] buttons;

    public PuzzleGame() {
        frame = new JFrame("Puzzle");
        panel = new JPanel();

        // adding all buttons to the frame & actionListener
        startButton.add(new JButton("New Game"));   // Start button
        startButton.addActionListener(this);

        frame.add(startButton, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }















    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
