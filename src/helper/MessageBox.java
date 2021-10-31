/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
 */
package helper;

import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MessageBox {

    public final static int YES = JOptionPane.YES_OPTION;
    public final static int NO = JOptionPane.NO_OPTION;
    

    public static int asking(String ask) {
        int jawab = JOptionPane.showConfirmDialog(null, ask);

        return jawab;
    }
    
    public static void showing(String info){
        JOptionPane.showMessageDialog(null, info);
    }
}
