/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import beans.Item;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author ASUS
 */
public class TextFormatter {

    public static String asUnderlinedHTML(String text) {
        return "<html><u>" + text + "</u></html>";
    }

    static int limitText = 16;

    public static int asNumeric(String currencyIn) {
        String val = currencyIn.replace("Rp.", "").replace(".", "").trim();
        return Integer.parseInt(val);
    }

    public static String asTabbed(String text1, String text2) {
        String output = null;
        int panjangHuruf = text1.length();
        String namaBaru = null;
        String spasi = " ";

        if (panjangHuruf >= limitText) {
            namaBaru = text1.substring(0, limitText) + " ";
            // get the limited text only
        } else {
            // once there is a gap
            int gap = limitText - panjangHuruf;
            // we will filled it by spaces
            for (int i = 0; i < gap; i++) {
                spasi += " ";
            }
            namaBaru = text1 + spasi;
        }

        output = namaBaru + text2;
        return output;
    }

    public static String asTabbedItemDetail(Item product) {
        String output = null;
        int panjangHuruf = product.getName().length();
        String namaBaru = null;
        String spasi = " ";

        if (panjangHuruf >= limitText) {
            namaBaru = product.getName().substring(0, limitText) + " ";
            // get the limited text only
        } else {
            // once there is a gap
            int gap = limitText - panjangHuruf;
            // we will filled it by spaces
            for (int i = 0; i < gap; i++) {
                spasi += " ";
            }
            namaBaru = product.getName() + spasi;
        }

        output = namaBaru + asCurrency(product.getPrice());

        return output;
    }

    public static String asCurrency(double val) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        if (val <= 999) {
            formatRp.setCurrencySymbol("Rp.       ");
        } else if (val <= 9999) {
            formatRp.setCurrencySymbol("Rp.     ");
        } else if (val <= 99999) {
            formatRp.setCurrencySymbol("Rp.    ");
        } else if (val <= 999999) {
            formatRp.setCurrencySymbol("Rp.   ");
        } else if (val <= 9999999) {
            formatRp.setCurrencySymbol("Rp. ");
        }

        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        //System.out.printf("Harga Rupiah: %s %n", kursIndonesia.format(harga));
        // and we clear out the cent
        //return kursIndonesia.format(val);
        return kursIndonesia.format(val).replace(",00", "");
    }

}
