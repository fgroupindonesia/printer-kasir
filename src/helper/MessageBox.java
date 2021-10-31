/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
