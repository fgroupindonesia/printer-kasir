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
import helper.PrintUtility;

/**
 *
 * @author ASUS
 */
public class Executor {

    public static void main(String[] args) {

        FileSystemManager fsm = new FileSystemManager();
        PrintUtility pu = new PrintUtility();
        pu.preparePrinter();
        

        Receipt data = new Receipt();
        data.setTitle("Training & Digital Solutions Provider");
        data.setPicture(fsm.getProfilePictureObject("fgroup.jpg"));
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

        pu.setReceipt(data);
        pu.print();

    }
}
