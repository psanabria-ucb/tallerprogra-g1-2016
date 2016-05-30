package bo.edu.ucbcba.Taller.view;

import bo.edu.ucbcba.Taller.controller.SaleController;
import bo.edu.ucbcba.Taller.controller.StockController;
import bo.edu.ucbcba.Taller.exceptions.ValidationException;
import bo.edu.ucbcba.Taller.model.Sale;
import bo.edu.ucbcba.Taller.model.Stock;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Usuario on 27/05/2016.
 */
public class RegisterSaleForm extends JDialog {
    private JPanel rootPanel;
    private JTextField cant;
    private JTextField code;
    private JTable saleTable;
    private JTextField searchText;
    private JButton searchButton;
    private JTextField total;
    private JComboBox stock;
    private JButton deleteButton;
    private JButton cancelButton;
    private JButton saveButton;
    private JTextField day;
    private JTextField month;
    private JTextField year;

    private StockController controllerstock;
    private SaleController controllersale;

    public RegisterSaleForm(JFrame parent) {

        super(parent, "Ventas", true);
        setContentPane(rootPanel);
        pack();
        setResizable(false);
        setSize(900, 400);

        controllerstock = new StockController();
        controllersale = new SaleController();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUser();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        populateTable();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateTable();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletestock();
            }
        });
        populateComboBox();
    }

    private void populateComboBox() {
        List<Stock> stocks = controllerstock.getAllStock();
        for (Stock s : stocks) {
            stock.addItem(s);
        }
    }

   /* public void clearstock() {
        Stock s = (Stock) stock.getSelectedItem();

        code.setText("");
        date.setText("");

        cant.setText("");
        total.setText("");
    }*/

    public void deletestock() {
        DefaultTableModel tm = (DefaultTableModel) saleTable.getModel();
        int id = (Integer) tm.getValueAt(saleTable.getSelectedRow(), 0);
        if (!(id == -1))
            controllersale.delete(id);
        else
            throw new ValidationException("Porfavor seleccione un repuesto para eliminar");
        populateTable();
    }

    private void saveUser() {
        try {
            Stock s = (Stock) stock.getSelectedItem();
            controllersale.create(code.getText(),
                    day.getText(),
                    month.getText(),
                    year.getText(),
                    s,
                    cant.getText(),
                    total.getText());
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Format error", JOptionPane.ERROR_MESSAGE);
        }
        populateTable();
        // clearstock();
    }

    private void cancel() {
        setVisible(false);
        dispose();
    }

    private void populateTable() {

        List<Sale> sale = controllersale.searchSale(searchText.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N°");
        model.addColumn("Codigo");
        model.addColumn("Fecha");
        model.addColumn("Repuesto");
        model.addColumn("Cantidad");
        model.addColumn("total");
        saleTable.setModel(model);

        for (Sale m : sale) {
            Object[] row = new Object[6];

            row[0] = m.getId();
            row[1] = m.getCode();
            row[2] = m.getD();
            row[3] = m.getstocks();
            row[4] = m.getcant();
            row[5] = m.gettotal();
            model.addRow(row);
        }

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
        rootPanel.setLayout(new GridLayoutManager(9, 7, new Insets(0, 0, 0, 0), -1, -1));
        cant = new JTextField();
        cant.setText("");
        rootPanel.add(cant, new GridConstraints(6, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        code = new JTextField();
        code.setText("");
        rootPanel.add(code, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        rootPanel.add(scrollPane1, new GridConstraints(1, 3, 8, 3, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        saleTable = new JTable();
        scrollPane1.setViewportView(saleTable);
        final JLabel label1 = new JLabel();
        label1.setText("Codigo");
        rootPanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        searchText = new JTextField();
        rootPanel.add(searchText, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Registro de ventas");
        rootPanel.add(label2, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Ingrese codigo");
        rootPanel.add(label3, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        total = new JTextField();
        total.setText("");
        rootPanel.add(total, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        deleteButton = new JButton();
        deleteButton.setText("Eliminar");
        rootPanel.add(deleteButton, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setText("Cancelar");
        rootPanel.add(cancelButton, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Guardar");
        rootPanel.add(saveButton, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Dia");
        rootPanel.add(label4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Repuesto");
        rootPanel.add(label5, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Cantidad");
        rootPanel.add(label6, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Total");
        rootPanel.add(label7, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stock = new JComboBox();
        rootPanel.add(stock, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Mes");
        rootPanel.add(label8, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        month = new JTextField();
        month.setText("");
        rootPanel.add(month, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Año");
        rootPanel.add(label9, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        year = new JTextField();
        year.setText("");
        rootPanel.add(year, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        day = new JTextField();
        rootPanel.add(day, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        searchButton = new JButton();
        searchButton.setText("Buscar");
        rootPanel.add(searchButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
