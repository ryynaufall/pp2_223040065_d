import java.awt.*;
import javax.swing.*;

public class HelloGridBagLayout extends JFrame {

    public HelloGridBagLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label di bagian atas
        JLabel headLabel = new JLabel("Layout in action: GridBagLayout", JLabel.CENTER);

        // Panel utama dengan GridBagLayout
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Tombol 1
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JButton("Button 1"), gbc);

        // Tombol 2
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);

        // Tombol 3 (pengaturan ipady diubah agar tidak tumpang tindih dengan Button 1)
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;  // Menambah tinggi tombol
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JButton("Button 3"), gbc);

        // Tombol 4
        gbc.ipady = 20;  // Reset ipady
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JButton("Button 4"), gbc);

        // Tombol 5 dengan gridwidth 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 5"), gbc);

        // Atur layout JFrame menjadi GridLayout (2 baris, 1 kolom)
        this.setLayout(new GridLayout(2, 1));
        this.add(headLabel);  // Tambahkan label
        this.add(panel);      // Tambahkan panel dengan tombol

        this.setSize(400, 400);  // Set ukuran jendela
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridBagLayout h = new HelloGridBagLayout();
                h.setVisible(true);  // Set jendela terlihat
            }
        });
    }
}
