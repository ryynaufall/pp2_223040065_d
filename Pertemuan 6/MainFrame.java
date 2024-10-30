import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Aplikasi Manajemen Data Produk");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Membuat JMenu untuk navigasi
        JMenu menu = new JMenu("Menu");
        JMenuItem productDetailForm = new JMenuItem("Form Data Detail Produk");
        JMenuItem stockForm = new JMenuItem("Form Stok Produk");

        // Tambahkan item ke menu
        menu.add(productDetailForm);
        menu.add(stockForm);

        // Tambahkan action listener untuk item
        productDetailForm.addActionListener(e -> new ProductDetailForm().setVisible(true));
        stockForm.addActionListener(e -> new StockForm().setVisible(true));

        // Tambahkan menu ke JMenuBar
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

// Form Data Detail Produk
class ProductDetailForm extends JFrame {
    private JTextField nameField, priceField;
    private JComboBox<String> categoryComboBox;
    private JTextArea descriptionArea;
    private JCheckBox availabilityCheckBox;
    private JTable table;
    private DefaultTableModel tableModel;

    public ProductDetailForm() {
        setTitle("Form Data Detail Produk");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        // JTextField untuk Nama Produk
        inputPanel.add(new JLabel("Nama Produk:"));
        nameField = new JTextField(20);
        inputPanel.add(nameField);

        // JComboBox untuk Kategori Produk
        inputPanel.add(new JLabel("Kategori:"));
        categoryComboBox = new JComboBox<>(new String[]{"Elektronik", "Furnitur", "Pakaian", "Makanan"});
        inputPanel.add(categoryComboBox);

        // JTextArea untuk Deskripsi
        inputPanel.add(new JLabel("Deskripsi:"));
        descriptionArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(descriptionArea));

        // JTextField untuk Harga
        inputPanel.add(new JLabel("Harga:"));
        priceField = new JTextField(20);
        inputPanel.add(priceField);

        // JCheckBox untuk Ketersediaan
        inputPanel.add(new JLabel("Ketersediaan:"));
        availabilityCheckBox = new JCheckBox("Tersedia");
        inputPanel.add(availabilityCheckBox);

        add(inputPanel, BorderLayout.NORTH);

        // JTable untuk menampung data input
        tableModel = new DefaultTableModel(new String[]{"Nama Produk", "Kategori", "Deskripsi", "Harga", "Ketersediaan"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Tombol untuk menambahkan data ke JTable
        JButton addButton = new JButton("Tambah Data");
        addButton.addActionListener(e -> addDataToTable());
        add(addButton, BorderLayout.SOUTH);
    }

    private void addDataToTable() {
        String availability = availabilityCheckBox.isSelected() ? "Tersedia" : "Tidak Tersedia";
        tableModel.addRow(new Object[]{
                nameField.getText(), categoryComboBox.getSelectedItem(), descriptionArea.getText(),
                priceField.getText(), availability
        });
    }
}

// Form Stok Produk
class StockForm extends JFrame {
    private JTextField quantityField;
    private JComboBox<String> warehouseComboBox;
    private JSpinner arrivalDateSpinner, estimatedSalesSpinner;
    private JTable table;
    private DefaultTableModel tableModel;

    public StockForm() {
        setTitle("Form Stok Produk");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        // JTextField untuk Jumlah Stok
        inputPanel.add(new JLabel("Jumlah Stok:"));
        quantityField = new JTextField(20);
        inputPanel.add(quantityField);

        // JComboBox untuk Lokasi Gudang
        inputPanel.add(new JLabel("Lokasi Gudang:"));
        warehouseComboBox = new JComboBox<>(new String[]{"Gudang A", "Gudang B", "Gudang C"});
        inputPanel.add(warehouseComboBox);

        // JSpinner untuk Tanggal Kedatangan
        inputPanel.add(new JLabel("Tanggal Kedatangan:"));
        arrivalDateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(arrivalDateSpinner, "dd/MM/yyyy");
        arrivalDateSpinner.setEditor(dateEditor);
        inputPanel.add(arrivalDateSpinner);

        // JSpinner untuk Estimasi Penjualan
        inputPanel.add(new JLabel("Estimasi Penjualan:"));
        estimatedSalesSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 10));
        inputPanel.add(estimatedSalesSpinner);

        add(inputPanel, BorderLayout.NORTH);

        // JTable untuk menampung data input
        tableModel = new DefaultTableModel(new String[]{"Jumlah Stok", "Lokasi Gudang", "Tanggal Kedatangan", "Estimasi Penjualan"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Tombol untuk menambahkan data ke JTable
        JButton addButton = new JButton("Tambah Data");
        addButton.addActionListener(e -> addDataToTable());
        add(addButton, BorderLayout.SOUTH);
    }

    private void addDataToTable() {
        tableModel.addRow(new Object[]{
                quantityField.getText(), warehouseComboBox.getSelectedItem(), arrivalDateSpinner.getValue(),
                estimatedSalesSpinner.getValue()
        });
    }
}