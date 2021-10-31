/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;

/**
 *
 * @author ASUS
 */
public class Profile {
    private String title;
    private String address;
    private File picture;

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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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
    
}
