package Puzzle15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

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

    void createTiles() {
        panel.setLayout((new GridLayout(4, 4)));
        buttons = new JButton[16];
        for (int i = 0; i < buttons.length - 1; i++) {
            buttons[i] = new JButton("" + (i + 1));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        buttons[buttons.length - 1] = new JButton();
        buttons[buttons.length - 1].setOpaque(false);
        buttons[buttons.length - 1].setContentAreaFilled(false);
        buttons[buttons.length - 1].setBorderPainted(false);

        buttons[buttons.length - 1].addActionListener(this);
        panel.add(buttons[buttons.length - 1]);
    }

    void shuffleTiles() {
        panel.removeAll();
        for (int i = buttons.length - 1 - 1; i >= 0 ; i--) {
            int index = (int) (Math.random() * i);

            // To demonstrate uncomment index = i;
            // index = i;

            JButton temp = buttons[i];
            buttons[i] = buttons[index];
            buttons[index] = temp;
        }
        for (int i = 0; i < buttons.length - 1; i++) {
            panel.add(buttons[i]);
        }
        panel.validate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Button New Game
        if (e.getSource() == startButton) {
            indexEmptyButton = 15;
            createTiles();
            shuffleTiles();
        }
        buttonPush(e);
    }

    // This method verifies that the puzzle is successfully complete
    private boolean hasPlayerWon() {
        boolean isInOrder = true;
        int i = 0;
        while(isInOrder && i < buttons.length - 1) {
            if (!buttons[i].getText().isEmpty()) {
                isInOrder = parseInt(buttons[i].getText()) == i + 1;
                i++;
            } else {
                isInOrder = false;
            }
        }
        return isInOrder;
    }


    // What it happens when the user press the buttons (play)
    private void buttonPush(ActionEvent e) {

    }
}
