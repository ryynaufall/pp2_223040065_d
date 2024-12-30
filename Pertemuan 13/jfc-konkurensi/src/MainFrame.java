import java.awt.*;
import javax.swing.*;

public class MainFrame {
    public static void main(String[] args) {
        // Membuat frame utama
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            // Label untuk status
            JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);

            // Progress bar
            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            // Tombol aksi
            JButton startButton = new JButton("Mulai");
            startButton.addActionListener(e -> {
                // Jalankan tugas berat di thread terpisah
                new Thread(() -> {
                    for (int i = 0; i <= 60; i++) {
                        final int progress = i;
                        SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    SwingUtilities.invokeLater(() -> statusLabel.setText("Tugas selesai!"));
                }).start();
            });

            // Tambahkan komponen ke frame
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            // Tampilkan frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}