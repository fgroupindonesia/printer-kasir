/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
 */
package frame;

import beans.Item;
import beans.Profile;
import beans.Receipt;
import helper.Effects;
import helper.FileSystemManager;
import helper.MessageBox;
import helper.PrintUtility;
import helper.TextFormatter;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import simulation.AccessOperation;

/**
 *
 * @author ASUS
 */
public class PrinterKasirFrame extends javax.swing.JFrame {

    /**
     * Creates new form PrinterKasirFrame
     */
    PrintUtility pu = new PrintUtility();
    ArrayList<Item> dataOrders = new ArrayList<Item>();
    Receipt resi = new Receipt();
    FileSystemManager fsm = new FileSystemManager();
    AccessOperation accessDB = new AccessOperation();
    Profile selectedProfile = null;

    public PrinterKasirFrame() {
        initComponents();

        pu.preparePrinter();
        renderComboboxPrinterName(pu.getPrintersAvailable());
        prepareProfiles();
    }

    // thils will be called by the anther frame
    public void setProfile(Profile po) {
        selectedProfile = po;
    }

    private void renderComboboxPrinterName(ArrayList<String> dataIn) {
        comboboxPrinterNameList.removeAllItems();
        for (String nameDevice : dataIn) {
            comboboxPrinterNameList.addItem(nameDevice);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        labelTotalPriceText = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        buttonSaveOrder = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textboxClientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboboxClientType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        textboxItemName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textboxItemPrice = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboboxProfile = new javax.swing.JComboBox<>();
        labelAddAnotherProfile = new javax.swing.JLabel();
        buttonPrintData = new javax.swing.JButton();
        buttonClearData = new javax.swing.JButton();
        buttonOpenDatabase = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboboxPrinterNameList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Printer Kasir");
        setIconImage(getFrameIcon());
        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("for ESCPOS USB Printer Hardware only!");
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel6.setLayout(new java.awt.BorderLayout());

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item's Name", "Price", "-"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableData.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tableDataMouseMoved(evt);
            }
        });
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(512, 50));
        jPanel9.setLayout(new java.awt.BorderLayout());

        labelTotalPriceText.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTotalPriceText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotalPriceText.setText("Total : Rp. 0");
        jPanel9.add(labelTotalPriceText, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Order's Detail"));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel5.setLayout(new java.awt.BorderLayout());

        buttonSaveOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/images/diskette-logo.png"))); // NOI18N
        buttonSaveOrder.setText("Save");
        buttonSaveOrder.setEnabled(false);
        buttonSaveOrder.setPreferredSize(new java.awt.Dimension(57, 50));
        buttonSaveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveOrderActionPerformed(evt);
            }
        });
        jPanel5.add(buttonSaveOrder, java.awt.BorderLayout.PAGE_END);

        jPanel8.setPreferredSize(new java.awt.Dimension(88, 100));
        jPanel8.setLayout(new java.awt.GridLayout(12, 1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Client's Name :");
        jPanel8.add(jLabel2);

        textboxClientName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textboxClientName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textboxClientName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textboxClientNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textboxClientNameFocusLost(evt);
            }
        });
        jPanel8.add(textboxClientName);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Client's Type :");
        jPanel8.add(jLabel3);

        comboboxClientType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxClientType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "general", "student", "patient" }));
        jPanel8.add(comboboxClientType);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Item's Name :");
        jPanel8.add(jLabel4);

        textboxItemName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textboxItemName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textboxItemName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textboxItemNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textboxItemNameFocusLost(evt);
            }
        });
        jPanel8.add(textboxItemName);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Price :");
        jPanel8.add(jLabel5);

        textboxItemPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textboxItemPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textboxItemPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textboxItemPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textboxItemPriceFocusLost(evt);
            }
        });
        textboxItemPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textboxItemPriceKeyTyped(evt);
            }
        });
        jPanel8.add(textboxItemPrice);

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5, java.awt.BorderLayout.WEST);

        jLabel6.setText("Profile :");
        jPanel7.add(jLabel6);

        comboboxProfile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxProfile.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel7.add(comboboxProfile);

        labelAddAnotherProfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelAddAnotherProfile.setForeground(new java.awt.Color(0, 0, 255));
        labelAddAnotherProfile.setText("<html><u>Add Another</u></html>");
        labelAddAnotherProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAddAnotherProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddAnotherProfileMouseClicked(evt);
            }
        });
        jPanel7.add(labelAddAnotherProfile);

        buttonPrintData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/images/printer-logo.png"))); // NOI18N
        buttonPrintData.setText("Print");
        buttonPrintData.setEnabled(false);
        buttonPrintData.setPreferredSize(new java.awt.Dimension(100, 41));
        buttonPrintData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintDataActionPerformed(evt);
            }
        });
        jPanel7.add(buttonPrintData);

        buttonClearData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/images/clear-logo.png"))); // NOI18N
        buttonClearData.setText("Clear");
        buttonClearData.setEnabled(false);
        buttonClearData.setPreferredSize(new java.awt.Dimension(100, 41));
        buttonClearData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearDataActionPerformed(evt);
            }
        });
        jPanel7.add(buttonClearData);

        buttonOpenDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frame/images/database-logo.png"))); // NOI18N
        buttonOpenDatabase.setText("Database");
        buttonOpenDatabase.setPreferredSize(new java.awt.Dimension(150, 41));
        buttonOpenDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenDatabaseActionPerformed(evt);
            }
        });
        jPanel7.add(buttonOpenDatabase);

        jPanel4.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Printer"));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel3.setLayout(new java.awt.BorderLayout());

        comboboxPrinterNameList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxPrinterNameList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxPrinterNameList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxPrinterNameListActionPerformed(evt);
            }
        });
        jPanel3.add(comboboxPrinterNameList, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isNumber(String val) {
        boolean r = false;
        try {
            Integer.parseInt(val);

            r = true;

        } catch (Exception ex) {
            r = false;
        }

        return r;
    }

    private void textboxItemPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textboxItemPriceFocusLost

        Effects.textboxLostFocus(textboxItemPrice);

        String val = textboxItemPrice.getText();

        if (val.length() > 0) {
            if (isNumber(val)) {
                if (!val.contains("Rp")) {
                    textboxItemPrice.setText(TextFormatter.asCurrency(Integer.parseInt(val)));
                }
            }else{
                MessageBox.showing("Please input valid number only!");
                textboxItemPrice.requestFocus();
            }
        }

        isFormFilled();

    }//GEN-LAST:event_textboxItemPriceFocusLost

    private int length(JTextField jt) {
        return jt.getText().length();
    }

    private void isFormFilled() {
        boolean stat = false;
        if (length(textboxItemName) > 0 && length(textboxClientName) > 0 && length(textboxItemPrice) > 0) {
            stat = true;
        } else {
            stat = false;
        }

        buttonSaveOrder.setEnabled(stat);

    }

    private void buttonSaveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveOrderActionPerformed

        // put into array then to the table
        Item n = new Item();
        n.setName(textboxItemName.getText());
        n.setPrice(TextFormatter.asNumeric(textboxItemPrice.getText()));
        n.setQuantity(1);

        dataOrders.add(n);

        renderTable();

        buttonSaveOrder.setEnabled(false);
        clearTextbox(textboxItemName);
        clearTextbox(textboxItemPrice);
    }//GEN-LAST:event_buttonSaveOrderActionPerformed

    private void clearTextbox(JTextField jtf) {
        jtf.setText("");

        Effects.textboxLostFocus(jtf);
    }

    private Image getFrameIcon() {
        return new ImageIcon(fsm.getFrameIconPath()).getImage();
    }

    public void prepareProfiles() {

        ArrayList<Profile> dataProf = fsm.getAllProfiles();
        renderComboboxProfile(dataProf);

    }

    private void renderComboboxProfile(ArrayList<Profile> dataIn) {
        comboboxProfile.removeAllItems();
        for (Profile prof : dataIn) {
            comboboxProfile.addItem(prof.getCompanyName());

        }

        selectedProfile = fsm.readProfileSelected();
        comboboxProfile.setSelectedItem(selectedProfile.getCompanyName());

    }

    private void buttonClearDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearDataActionPerformed

        dataOrders.clear();
        renderTable();
        resi = new Receipt();

        clearTextbox(textboxItemName);
        clearTextbox(textboxItemPrice);
        clearTextbox(textboxClientName);

        buttonClearData.setEnabled(false);

    }//GEN-LAST:event_buttonClearDataActionPerformed

    private void textboxClientNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textboxClientNameFocusLost

        Effects.textboxLostFocus(textboxClientName);

        isFormFilled();

    }//GEN-LAST:event_textboxClientNameFocusLost

    private void textboxItemNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textboxItemNameFocusLost

        Effects.textboxLostFocus(textboxItemName);

        isFormFilled();

    }//GEN-LAST:event_textboxItemNameFocusLost

    private void tableDataMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseMoved
        int row = tableData.rowAtPoint(evt.getPoint());
        int col = tableData.columnAtPoint(evt.getPoint());

        if (col != 2) {
            tableData.setCursor(Cursor.getDefaultCursor());
        } else {
            tableData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }//GEN-LAST:event_tableDataMouseMoved

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        int row = tableData.rowAtPoint(evt.getPoint());
        int col = tableData.columnAtPoint(evt.getPoint());
        String perintah = tableData.getValueAt(row, col).toString();

        if (col == 2 && perintah.contains("delete")) {
            DefaultTableModel dtm = (DefaultTableModel) tableData.getModel();
            dtm.removeRow(row);

            // remove from the arraylist too
            dataOrders.remove(row);
            calculateTotal();

            if (dtm.getRowCount() > 0) {
                buttonClearData.setEnabled(true);
                buttonPrintData.setEnabled(true);
            } else {
                buttonClearData.setEnabled(false);
                buttonPrintData.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tableDataMouseClicked

    private void textboxItemPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textboxItemPriceFocusGained

        Effects.textboxGainedFocus(textboxItemPrice);

        String val = textboxItemPrice.getText();

        if (val.contains("Rp")) {
            // clear the currency
            textboxItemPrice.setText(TextFormatter.asNumeric(val) + "");
        }

    }//GEN-LAST:event_textboxItemPriceFocusGained

    private void textboxClientNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textboxClientNameFocusGained
        Effects.textboxGainedFocus(textboxClientName);
    }//GEN-LAST:event_textboxClientNameFocusGained

    private void textboxItemNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textboxItemNameFocusGained
        Effects.textboxGainedFocus(textboxItemName);
    }//GEN-LAST:event_textboxItemNameFocusGained

    private void textboxItemPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textboxItemPriceKeyTyped

        isFormFilled();

    }//GEN-LAST:event_textboxItemPriceKeyTyped

    private void labelAddAnotherProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddAnotherProfileMouseClicked
        ProfileDialog prf = new ProfileDialog(this, true);
        prf.setVisible(true);
    }//GEN-LAST:event_labelAddAnotherProfileMouseClicked

    private void buttonOpenDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenDatabaseActionPerformed

        try {
            Desktop p = Desktop.getDesktop();
            p.open(new File(fsm.getDBCompletePath()));
        } catch (Exception ex) {
            System.err.println("Error when opening database." + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_buttonOpenDatabaseActionPerformed

    private void buttonPrintDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintDataActionPerformed

        // set the printer driver
        applyPrinterChosen();

        // grab all the values from arrays
        // because array reflect the jtable too
        // and save it into Database
        resi.setShopList(dataOrders);

        resi.setCompanyName(selectedProfile.getCompanyName());
        resi.setTitle(selectedProfile.getTitle());
        resi.setPicture(selectedProfile.getPicture());
        resi.generateUniqueNumber();
        resi.setDateMode(Receipt.LONG_DATE);

        //data.setTitle("Rumah Terapi Herbal");
        //data.setPicture(fsm.getProfilePictureObject("rth.jpg"));
        resi.setClientName(textboxClientName.getText());
        resi.setClientType(comboboxClientType.getSelectedItem().toString());

        /*
        Item item = new Item();
        item.setName("Ms. Office");
        item.setQuantity(1);
        item.setPrice(500000);
         */
        // clear the form
        clearTextbox(textboxItemName);
        clearTextbox(textboxItemPrice);

        // call the printer
        pu.setTitleMode(PrintUtility.COMPANY_NAME_ONLY);
        pu.setReceipt(resi);
        pu.print();

        accessDB.addData(resi);
        accessDB.exit();

        // clear back the behind the scenes
        dataOrders.clear();
        resi = new Receipt();
        renderTable();

    }//GEN-LAST:event_buttonPrintDataActionPerformed

    private void comboboxPrinterNameListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxPrinterNameListActionPerformed

        // set the printer into the print utility
        applyPrinterChosen();

    }//GEN-LAST:event_comboboxPrinterNameListActionPerformed

    private void applyPrinterChosen() {
        if (comboboxPrinterNameList.getSelectedIndex() != -1) {
            String nama = comboboxPrinterNameList.getSelectedItem().toString();
            pu.setPrinterChosen(nama);
            System.out.println("Memilih printer " + nama);
        }
    }

    private void calculateTotal() {

        int total = 0;
        for (Item it : dataOrders) {
            total += (it.getPrice() * it.getQuantity());
        }

        labelTotalPriceText.setText("Total : " + TextFormatter.asCurrency(total));

    }

    private void renderTable() {

        // clear first
        DefaultTableModel dtm = (DefaultTableModel) tableData.getModel();
        dtm.setRowCount(0);

        int cash = 0;

        // we render from arraylist to jtable
        for (Item itemNa : dataOrders) {
            Object[] dataNa = {itemNa.getName(), itemNa.getPrice(), TextFormatter.asUnderlinedHTML("delete")};
            dtm.addRow(dataNa);

        }

        calculateTotal();

        if (dtm.getRowCount() > 0) {
            buttonClearData.setEnabled(true);
            buttonPrintData.setEnabled(true);
        } else {
            buttonClearData.setEnabled(false);
            buttonPrintData.setEnabled(false);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrinterKasirFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrinterKasirFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrinterKasirFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrinterKasirFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrinterKasirFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClearData;
    private javax.swing.JButton buttonOpenDatabase;
    private javax.swing.JButton buttonPrintData;
    private javax.swing.JButton buttonSaveOrder;
    private javax.swing.JComboBox<String> comboboxClientType;
    private javax.swing.JComboBox<String> comboboxPrinterNameList;
    private javax.swing.JComboBox<String> comboboxProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAddAnotherProfile;
    private javax.swing.JLabel labelTotalPriceText;
    private javax.swing.JTable tableData;
    private javax.swing.JTextField textboxClientName;
    private javax.swing.JTextField textboxItemName;
    private javax.swing.JTextField textboxItemPrice;
    // End of variables declaration//GEN-END:variables
}
