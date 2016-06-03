package bo.edu.ucbcba.Taller.view;

import bo.edu.ucbcba.Taller.controller.ClienteVehiculoController;
import bo.edu.ucbcba.Taller.controller.CustomerController;
import bo.edu.ucbcba.Taller.exceptions.ValidationException;
import bo.edu.ucbcba.Taller.model.Customer;
import bo.edu.ucbcba.Taller.model.Vehiculo;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Osmar on 31/05/2016.
 */
public class RegistroClienteVehiculo extends JDialog {
    private JTextField TextCI;
    private JTextField TextNombre;
    private JTextField TextPaterno;
    private JTextField TextMaterno;
    private JTextField TextDireccion;
    private JTextField TextTelefono;
    private JTextField textPlaca;
    private JTextField textModelo;
    private JComboBox comboBoxMarca;
    private JComboBox comboBoxOrigen;
    private JComboBox comboBoxColor;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTable ShowTable;
    private JPanel rootPanel;
    private CustomerController customerController;
    private ClienteVehiculoController clienteVehiculoController;

    public RegistroClienteVehiculo(JFrame parent) {
        super(parent, " REGISTRO DE CLIENTE Y VEHICULO", true);
        setContentPane(rootPanel);
        setSize(500, 400);
        customerController = new CustomerController();
        clienteVehiculoController = new ClienteVehiculoController();
        pack();
        setResizable(false);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar();
                //ShowTable();
                ShowTable1();
            }
        });
    }

    public void ShowTable() {
        List<Customer> man = customerController.show();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDO PATERNO");
        model.addColumn("APELLIDO MATERNO");
        model.addColumn("DIRECCION");
        model.addColumn("TELEFONO");
        ShowTable.setModel(model);
        for (Customer m : man) {
            Object[] row = new Object[7];
            row[0] = m.getId();
            row[1] = m.getCi();
            row[2] = m.getFirtsName();
            row[3] = m.getLastNameM();
            row[4] = m.getLastNameF();
            row[5] = m.getAddress();
            row[6] = m.getNumberPhone();
            model.addRow(row);
        }
    }

    public void ShowTable1() {
        List<Vehiculo> man1 = clienteVehiculoController.show();
        DefaultTableModel model1 = new DefaultTableModel();
        model1.addColumn("PLACA");
        model1.addColumn("COLOR");
        model1.addColumn("MARCA");
        model1.addColumn("MODELO");
        model1.addColumn("ORIGEN");
        ShowTable.setModel(model1);
        for (Vehiculo v : man1) {
            Object[] row1 = new Object[5];
            row1[0] = v.getPlaca();
            row1[1] = v.getColor();
            row1[2] = v.getMarca();
            row1[3] = v.getModelo();
            row1[4] = v.getOrigen();
            model1.addRow(row1);
        }
    }

    private void agregar() {
        try {
            customerController.create(TextCI.getText(), TextNombre.getText(), TextPaterno.getText(), TextMaterno.getText(), TextTelefono.getText(), TextDireccion.getText());
            clearMant();
            clienteVehiculoController.create(textPlaca.getText(), (String) comboBoxColor.getSelectedItem(), (String) comboBoxMarca.getSelectedItem(), textModelo.getText(), (String) comboBoxOrigen.getSelectedItem());
            ShowTable();
            clearMant();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR DE FORMATO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearMant() {
        textPlaca.setText("");
        comboBoxColor.setSelectedItem("");
        comboBoxMarca.setSelectedItem("");
        textModelo.setText("");
        comboBoxOrigen.setSelectedItem("");
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(7, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setFont(new Font(panel1.getFont().getName(), panel1.getFont().getStyle(), panel1.getFont().getSize()));
        rootPanel.add(panel1, new GridConstraints(0, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(90, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), Font.BOLD, 18));
        label1.setText(" CI O NIT");
        panel1.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), Font.BOLD, 18));
        label2.setText("  NOMBRE");
        panel1.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setFont(new Font(label3.getFont().getName(), Font.BOLD, 18));
        label3.setText("  APELIIDO PATERNO");
        label3.setVerticalAlignment(0);
        panel1.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setFont(new Font(label4.getFont().getName(), Font.BOLD, 18));
        label4.setText("  APELLIDO MATERNO");
        panel1.add(label4, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setFont(new Font(label5.getFont().getName(), Font.BOLD, 18));
        label5.setText("  DIRECCION");
        panel1.add(label5, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setFont(new Font(label6.getFont().getName(), Font.BOLD, 18));
        label6.setText("  TELEFONO");
        panel1.add(label6, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TextCI = new JTextField();
        TextCI.setText("");
        panel1.add(TextCI, new GridConstraints(1, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        TextNombre = new JTextField();
        panel1.add(TextNombre, new GridConstraints(2, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        TextPaterno = new JTextField();
        panel1.add(TextPaterno, new GridConstraints(3, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        TextMaterno = new JTextField();
        panel1.add(TextMaterno, new GridConstraints(4, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        TextDireccion = new JTextField();
        panel1.add(TextDireccion, new GridConstraints(5, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        TextTelefono = new JTextField();
        panel1.add(TextTelefono, new GridConstraints(6, 1, 1, 6, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setFont(new Font(label7.getFont().getName(), Font.BOLD, 20));
        label7.setText("  INGRESE DATOS DEL CLIENTE");
        panel1.add(label7, new GridConstraints(0, 0, 1, 7, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(panel2, new GridConstraints(0, 1, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setFont(new Font(label8.getFont().getName(), Font.BOLD, 18));
        label8.setText("    PLACA");
        panel2.add(label8, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setFont(new Font(label9.getFont().getName(), Font.BOLD, 18));
        label9.setText("    COLOR");
        panel2.add(label9, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setFont(new Font(label10.getFont().getName(), Font.BOLD, 18));
        label10.setText("    MARCA");
        panel2.add(label10, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setFont(new Font(label11.getFont().getName(), Font.BOLD, 18));
        label11.setText("    MODELO");
        panel2.add(label11, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setFont(new Font(label12.getFont().getName(), Font.BOLD, 18));
        label12.setText("    ORIGEN");
        panel2.add(label12, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textPlaca = new JTextField();
        panel2.add(textPlaca, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textModelo = new JTextField();
        panel2.add(textModelo, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxMarca = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("TOYOTA");
        defaultComboBoxModel1.addElement("NISSAN");
        defaultComboBoxModel1.addElement("MITSUBISHI");
        defaultComboBoxModel1.addElement("MAZDA");
        defaultComboBoxModel1.addElement("AUDI");
        defaultComboBoxModel1.addElement("BMW");
        defaultComboBoxModel1.addElement("MERCEDEZ");
        defaultComboBoxModel1.addElement("FIAT");
        comboBoxMarca.setModel(defaultComboBoxModel1);
        panel2.add(comboBoxMarca, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxOrigen = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("JAPON");
        defaultComboBoxModel2.addElement("EEUU");
        comboBoxOrigen.setModel(defaultComboBoxModel2);
        panel2.add(comboBoxOrigen, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setFont(new Font(label13.getFont().getName(), Font.BOLD, 18));
        label13.setText("    INGRESE DATOS DEL VEHICULO");
        panel2.add(label13, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxColor = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("ROJO");
        defaultComboBoxModel3.addElement("VERDE");
        defaultComboBoxModel3.addElement("AMARILLO");
        defaultComboBoxModel3.addElement("AZUL");
        defaultComboBoxModel3.addElement("NEGRO");
        defaultComboBoxModel3.addElement("BLANCO");
        defaultComboBoxModel3.addElement("PLOMO");
        defaultComboBoxModel3.addElement("CELESTE");
        defaultComboBoxModel3.addElement("CAFE");
        comboBoxColor.setModel(defaultComboBoxModel3);
        panel2.add(comboBoxColor, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnAceptar = new JButton();
        btnAceptar.setText("ACEPTAR");
        rootPanel.add(btnAceptar, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnCancelar = new JButton();
        btnCancelar.setText("CANCELAR");
        rootPanel.add(btnCancelar, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(panel3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ShowTable = new JTable();
        panel3.add(ShowTable, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
