/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
 */
package helper;

import beans.Item;
import beans.Receipt;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.PrintModeStyle;
import com.github.anastaciocintra.escpos.image.Bitonal;
import com.github.anastaciocintra.escpos.image.BitonalThreshold;
import com.github.anastaciocintra.escpos.image.CoffeeImageImpl;
import com.github.anastaciocintra.escpos.image.EscPosImage;
import com.github.anastaciocintra.escpos.image.RasterBitImageWrapper;
import com.github.anastaciocintra.output.PrinterOutputStream;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.print.PrintService;

/**
 *
 * @author ASUS
 */
public class PrintUtility {

    Receipt singleReceipt = new Receipt();
    boolean useCompanyName = false;
    public final static int TITLE_ONLY = 1, COMPANY_NAME_ONLY = 2;

    public void setTitleMode(int m) {

        if (m == TITLE_ONLY) {
            useCompanyName = true;
        } else {
            useCompanyName = false;
        }

    }

    public boolean isTitleModeUsingCompanyName() {
        return useCompanyName;
    }

    public void setReceipt(Receipt dataIn) {
        singleReceipt = dataIn;
    }

    String dateEngine = null;
    final String HR_LINE = "------------------------------";

    ArrayList<String> printerNameList = new ArrayList<String>();

    public ArrayList<String> getPrintersAvailable() {
        return printerNameList;
    }

    PrintModeStyle normal = new PrintModeStyle();

    Style title = new Style()
            .setFontSize(Style.FontSize._2, Style.FontSize._2)
            .setBold(true)
            .setJustification(EscPosConst.Justification.Center);

    Style titleh4 = new Style()
            .setFontSize(Style.FontSize._1, Style.FontSize._1)
            .setBold(true)
            .setJustification(EscPosConst.Justification.Center);

    Style subtitle = new Style()
            .setFontSize(Style.FontSize._1, Style.FontSize._1)
            .setJustification(EscPosConst.Justification.Left_Default)
            .setBold(true)
            .setUnderline(Style.Underline.OneDotThick);

    Style bold = new Style()
            .setFontSize(Style.FontSize._1, Style.FontSize._1)
            .setJustification(EscPosConst.Justification.Left_Default)
            .setBold(true);

    PrintService printService;
    PrinterOutputStream printerOutputStream;
    EscPos escpos;

    public void setDateMode(int modeDate) {
        if (modeDate == 1) {
            // short
            dateEngine = new SimpleDateFormat("dd/MM/yy").format(new Date());
        } else if (modeDate == 2) {
            // long
            dateEngine = new SimpleDateFormat("dd-MMM-yyyy hh:mm").format(new Date());
        }
    }

    public void setPrinterChosen(String printerName) {
        try {
            printService = PrinterOutputStream.getPrintServiceByName(printerName);
            printerOutputStream = new PrinterOutputStream(printService);
            escpos = new EscPos(printerOutputStream);
        } catch (Exception ex) {
            System.err.println("error when assigning printer! " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void preparePrinter() {
        try {
            System.out.println("========= Printer Names:");
            String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();

            for (String printServiceName : printServicesNames) {
                System.out.println(printServiceName);

                //if (printServiceName.contains("58mm")) {
                //    setPrinterChosen(printServiceName);
                //}
                //obj.printInfo(printServiceName);
                printerNameList.add(printServiceName);
            }
            System.out.println("========= end.");

        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("Error when preparing machine " + ex.getMessage());
        }

    }

    private boolean hasLogo() {
        boolean stat = false;

        if (singleReceipt.getPicture() != null) {
            stat = true;
        }

        return stat;
    }

    private void creatingDitherImage() {

        try {
            System.out.println("lokasi " + singleReceipt.getPicture());

            Bitonal algorithm = new BitonalThreshold(127);
            // creating the EscPosImage, need buffered image and algorithm.
            BufferedImage githubBufferedImage = ImageIO.read(singleReceipt.getPicture());
            EscPosImage escposImage = new EscPosImage(new CoffeeImageImpl(githubBufferedImage), algorithm);

            // this wrapper uses esc/pos sequence: "GS(L"
            //GraphicsImageWrapper imageWrapper = new GraphicsImageWrapper();
            RasterBitImageWrapper imageWrapper = new RasterBitImageWrapper();
            escpos.write(imageWrapper, escposImage);
            escpos.feed(2);
        } catch (Exception ex) {
            System.err.println("error while making dither image!");
            ex.printStackTrace();
        }

    }

    public void printTitleSafe() {
        int len = singleReceipt.getTitle().length();
        String firstText, secondText;

        int intakeLen = 19;

        try {

            if (len > intakeLen) {
                // grab the first 18
                // and the second one line by line
                firstText = singleReceipt.getTitle().substring(0, intakeLen);
                secondText = singleReceipt.getTitle().substring(intakeLen);

                escpos.writeLF(titleh4, firstText);
                escpos.writeLF(titleh4, secondText);
                escpos.feed(1);
            } else {
                // if less than 18
                // we use it directly 
                escpos.writeLF(titleh4, singleReceipt.getTitle());
                escpos.feed(1);
            }
        } catch (Exception ex) {
            System.err.println("Error while printing safe Title. ");
            ex.printStackTrace();
        }
    }

    public void print() {

        try {

            if (hasLogo()) {
                creatingDitherImage();
            }

            if (!isTitleModeUsingCompanyName()) {
                // print out the title instead of company name
                printTitleSafe();
            }else{
                // print out the company name
                 escpos.writeLF(title, singleReceipt.getCompanyName());
            }

            escpos.write(normal, "No.Resi\t: ");
            escpos.writeLF(subtitle, singleReceipt.generateUniqueNumber());
            escpos.write(normal, "Client\t: ");
            escpos.writeLF(subtitle, singleReceipt.getClientName());
            escpos.write(normal, "Jenis\t: ");
            escpos.writeLF(subtitle, singleReceipt.getClientType());
            escpos.write(normal, "Tanggal\t: ");
            escpos.writeLF(subtitle, singleReceipt.getDateText());
            escpos.writeLF(normal, HR_LINE);

            for (Item item : singleReceipt.getShopList()) {
                escpos.writeLF(normal, TextFormatter.asTabbedItemDetail(item));
            }
            escpos.writeLF(normal, HR_LINE);
            // escpos.feed(2);

            escpos.writeLF(bold, TextFormatter.asTabbed("TOTAL", TextFormatter.asCurrency(singleReceipt.getTotal())));
            escpos.writeLF(normal, HR_LINE);
            escpos.feed(4);
            //escpos.cut(EscPos.CutMode.FULL);

            escpos.close();
            printerOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error while printing " + ex.getMessage());
        }

    }

}
