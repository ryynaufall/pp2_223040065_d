package view;

import java.awt.*;
import javax.swing.*;

public class UserView extends JFrame {
    public JLabel statusLabel;
    public JButton startButton;
    public JProgressBar progressBar;

    public UserView() {
        setTitle("Proses Data");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        statusLabel = new JLabel("Klik Mulai untuk memproses data", JLabel.CENTER);
        startButton = new JButton("Mulai");
        progressBar = new JProgressBar(0, 100);

        progressBar.setStringPainted(true);

        add(statusLabel, BorderLayout.NORTH);
        add(progressBar, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }
}