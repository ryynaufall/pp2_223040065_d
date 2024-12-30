import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CrudForm extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtName, txtAge, txtEmail, txtAddress;
    private JButton btnAdd, btnUpdate, btnDelete, btnRefresh;

    private Connection connection;
    private String dbUrl = "jdbc:mysql://localhost:3306/mydb";
    private String dbUser = "root";
    private String dbPassword = "password";

    public CrudForm() {
        setTitle("CRUD Form with JTable");
        setLayout(new BorderLayout());
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Connect to the database
        connectDatabase();

        // Create table
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Email", "Address"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        formPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        formPanel.add(txtAge);

        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        formPanel.add(txtEmail);

        formPanel.add(new JLabel("Address:"));
        txtAddress = new JTextField();
        formPanel.add(txtAddress);

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnRefresh = new JButton("Refresh");

        formPanel.add(btnAdd);
        formPanel.add(btnUpdate);
        formPanel.add(btnDelete);
        formPanel.add(btnRefresh);

        add(formPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnAdd.addActionListener(e -> addRecord());
        btnUpdate.addActionListener(e -> updateRecord());
        btnDelete.addActionListener(e -> deleteRecord());
        btnRefresh.addActionListener(e -> loadTable());

        loadTable();
    }

    private void connectDatabase() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot connect to database: " + e.getMessage());
            System.exit(0);
        }
    }

    private void loadTable() {
        try {
            tableModel.setRowCount(0);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("address")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addRecord() {
        try {
            String sql = "INSERT INTO person (name, age, email, address) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, txtName.getText());
            ps.setInt(2, Integer.parseInt(txtAge.getText()));
            ps.setString(3, txtEmail.getText());
            ps.setString(4, txtAddress.getText());
            ps.executeUpdate();
            loadTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                String sql = "UPDATE person SET name = ?, age = ?, email = ?, address = ? WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, txtName.getText());
                ps.setInt(2, Integer.parseInt(txtAge.getText()));
                ps.setString(3, txtEmail.getText());
                ps.setString(4, txtAddress.getText());
                ps.setInt(5, id);
                ps.executeUpdate();
                loadTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
        }
    }

    private void deleteRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                String sql = "DELETE FROM person WHERE id = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                loadTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CrudForm form = new CrudForm();
            form.setVisible(true);
        });
    }
}
