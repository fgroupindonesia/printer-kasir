/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
 */
package beans;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Receipt {

    public String toString(){
        return "data resi : " + title + " " + companyName + " " + clientName + " " + clientType + " " + dateText;
    }
    
    private String title;
    private File picture;
    private String clientName;
    private String clientType;
    private String dateText;
    private ArrayList<Item> shopList = new ArrayList<Item>();
    private int total;
    private String tagNumber;
    private String companyName;
    
    public static final int LONG_DATE = 2, SHORT_DATE = 1;

    public String generateUniqueNumber() {
        this.setTagNumber("P." + new SimpleDateFormat("HHmmss").format(new Date()));
        return this.getTagNumber();
    }
    
    public void setDateMode(int modeDate) {
        if (modeDate == SHORT_DATE) {
            // short
            dateText = new SimpleDateFormat("dd/MM/yy").format(new Date());
        } else if (modeDate == LONG_DATE) {
            // long
            dateText = new SimpleDateFormat("dd-MMMM-yyyy HH:mm").format(new Date());
        }
    }

    public void shop(Item itemIn) {
        shopList.add(itemIn);

        this.calculate();
    }

    private void calculate() {
        int priceTotal = 0;
        for (Item i : shopList) {
            priceTotal += (i.getPrice() * i.getQuantity());
        }

        this.setTotal(priceTotal);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the shopList
     */
    public ArrayList<Item> getShopList() {
        return shopList;
    }

    /**
     * @param shopList the shopList to set
     */
    public void setShopList(ArrayList<Item> shopList) {
        this.shopList = shopList;
        this.calculate();
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientType
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * @return the dateText
     */
    public String getDateText() {
        return dateText;
    }

    /**
     * @param dateText the dateText to set
     */
    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    /**
     * @return the picture
     */
    public File getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(File picture) {
        this.picture = picture;
    }

    /**
     * @return the tagNumber
     */
    public String getTagNumber() {
        return tagNumber;
    }

    /**
     * @param tagNumber the tagNumber to set
     */
    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
