import javax.swing.*;
import java.awt.*;

public class BiodataForm {
    public static void main(String[] args) {
        // Buat Frame
        JFrame frame = new JFrame("Form Biodata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Buat Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5); // padding
        
        // Buat Komponen Form
        JLabel labelNama = new JLabel("Nama:");
        c.gridx = 0; c.gridy = 0;
        mainPanel.add(labelNama, c);

        JTextField fieldNama = new JTextField(15);
        c.gridx = 1; c.gridy = 0;
        mainPanel.add(fieldNama, c);
        
        JLabel labelHp = new JLabel("Nomor HP:");
        c.gridx = 0; c.gridy = 1;
        mainPanel.add(labelHp, c);
        
        JTextField fieldHp = new JTextField(15);
        c.gridx = 1; c.gridy = 1;
        mainPanel.add(fieldHp, c);
        
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        c.gridx = 0; c.gridy = 2;
        mainPanel.add(labelGender, c);
        
        JRadioButton maleButton = new JRadioButton("Laki-Laki");
        JRadioButton femaleButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        
        c.gridx = 1; c.gridy = 2;
        mainPanel.add(genderPanel, c);
        
        JCheckBox foreignerCheckBox = new JCheckBox("Warga Negara Asing");
        c.gridx = 1; c.gridy = 3;
        mainPanel.add(foreignerCheckBox, c);
        
        JButton saveButton = new JButton("Simpan");
        c.gridx = 1; c.gridy = 4;
        mainPanel.add(saveButton, c);
        
        // Menambahkan Panel ke Frame
        frame.add(mainPanel);
        
        frame.setVisible(true);
    }
}