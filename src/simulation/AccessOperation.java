/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
 */
package simulation;

import beans.Item;
import beans.Receipt;
import helper.FileSystemManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class AccessOperation {

    FileSystemManager fsm = new FileSystemManager();
    Connection conn;

    private Receipt generateDummyReceipt() {
        Receipt data = new Receipt();
        data.setCompanyName("FGroupIndonesia");
        data.setTitle("Training & Digital Solutions Provider");
        data.setPicture(fsm.getProfilePictureObject("fgroup.jpg"));
        data.generateUniqueNumber();
        data.setDateMode(Receipt.LONG_DATE);

        //data.setTitle("Rumah Terapi Herbal");
        //data.setPicture(fsm.getProfilePictureObject("rth.jpg"));
        data.setClientName("ayi");
        data.setClientType("umum");

        Item item = new Item();
        item.setName("Ms. Office");
        item.setQuantity(1);
        item.setPrice(500000);

        Item item2 = new Item();
        item2.setName("Java Prog.");
        item2.setQuantity(1);
        item2.setPrice(650000);

        Item item3 = new Item();
        item3.setName("Photoshop CS6");
        item3.setQuantity(1);
        item3.setPrice(750000);

        data.shop(item);
        data.shop(item2);
        data.shop(item3);

        return data;
    }

    public static void main(String[] args) {

        /*System.setProperty("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.NoOpLog");*/
        AccessOperation test = new AccessOperation();

        test.addData(test.generateDummyReceipt());
        test.exit();
    }

    public AccessOperation() {

        try {

            conn = DriverManager.getConnection(
                    "jdbc:ucanaccess://" + fsm.getDBCompletePath());

        } catch (Exception ex) {
            System.err.println("Error when accessing file access! " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void exit() {
        try {
                conn.close();
        } catch (Exception ex) {
            System.err.println("Error when closing ms access db!" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void readData() {
        try {
            Statement s = (Statement) conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM [Table_Transaksi]");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (Exception ex) {

        }

    }

    public void addData(Receipt resi) {

        PreparedStatement st = null;
        try {
            
            
            for (Item satuItem : resi.getShopList()) {
                String q = "INSERT INTO Table_Transaksi ([ID], [Keterangan], [Tanggal], [No_Resi], [Quantity], [Harga_Satuan], [Instansi], [Kategori], [Nama_Peserta]) "
                        + "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
                st = conn.prepareStatement(q);
                st.setString(1, satuItem.getName());
                st.setString(2, resi.getDateText());
                st.setString(3, resi.getTagNumber());
                st.setInt(4, satuItem.getQuantity());
                st.setInt(5, satuItem.getPrice());
                st.setString(6, resi.getCompanyName());
                st.setString(7, resi.getClientType());
                st.setString(8, resi.getClientName());
                st.executeUpdate();
                
                
                System.out.println("Mencoba saving " + satuItem.toString() + "\ndari"+ resi.toString());
                
                conn.commit();
            }

            st.close();
            
        } catch (Exception ex) {
            System.err.println("Error when adding new data into ms access table! " + ex.getMessage());
            ex.printStackTrace();
        }

    }
}
