import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        // Membuat Frame 
        JFrame frame = new JFrame("MouseListener Example");

        // Membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini.");

        // Menambahkan MouseListener ke label
        label.addMouseListener(new MouseListener() {
            // Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() +")");
            }

            // Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() +")");
            }

            // Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() +")");
            }

            // Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered the area.");
            }

            // Dijalankan ketika mouse diklik (klik kiri, kanan atau tengah)
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse Exited the area.");
            }
        });

        // Menambahkan label ke frame
        frame.add(label);

        // Setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
