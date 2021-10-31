/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
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
