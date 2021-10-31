/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Effects {

    public static void textboxGainedFocus(JTextField t) {
        t.setBackground(Color.YELLOW);
    }

    public static void textboxLostFocus(JTextField t) {

        if (t.getText().length() > 0) {

            t.setBackground(null);

        } else {

            t.setBackground(Color.WHITE);

        }
    }
}
