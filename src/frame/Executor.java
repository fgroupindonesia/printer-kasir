/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import beans.Item;
import beans.Receipt;
import helper.FileSystemManager;
import helper.PrintUtility;

/**
 *
 * @author ASUS
 */
public class Executor {

    final static int LONG_DATE = 2;
    final static int SHORT_DATE = 1;

    public static void main(String[] args) {

        FileSystemManager fsm = new FileSystemManager();
        PrintUtility pu = new PrintUtility();
        pu.preparePrinter();
        pu.setDateMode(LONG_DATE);

        Receipt data = new Receipt();
        data.setTitle("Training & Digital Solutions Provider");
        data.setPicture(fsm.getProfilePictureObject("fgroup.jpg"));

        //data.setTitle("Rumah Terapi Herbal");
        //data.setPicture(fsm.getProfilePictureObject("rth.jpg"));
        data.setClientName("ayi");
        data.setClientType("umum");

        Item item = new Item();
        item.setName("Besok bsbsb");
        item.setQuantity(1);
        item.setPrice(100);

        Item item2 = new Item();
        item2.setName("agenda naon?");
        item2.setQuantity(1);
        item2.setPrice(200);

        Item item3 = new Item();
        item3.setName("de ayi?");
        item3.setQuantity(1);
        item3.setPrice(1000);

        data.shop(item);
        data.shop(item2);
        data.shop(item3);

        pu.setReceipt(data);
        pu.print();

    }
}
