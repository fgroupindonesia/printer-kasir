/*
 * @ PrinterKasir is made by FGroupIndonesia
 * for open source community!
 * Please contact our support if you need any assistance 
 * including : modification, trainings, and etc.
 */
package helper;

import beans.Profile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class FileSystemManager {

    String appName = "PrinterKasir";
    String rawName = "raw";
    // all data of profiles here
    String profileFileName = "profile.dat";
    // single data profile selected here
    String logoFileName = "logo.png";
    String dbFileName = "access.accdb";
    String completeSystemPath = System.getenv("APPDATA") + File.separator + appName;
    String completeRawPath = completeSystemPath + File.separator + rawName;
    String completeProfilePath = completeSystemPath + File.separator + profileFileName;
    String completeLogoPath = completeSystemPath + File.separator + logoFileName;
    String completeDBPath = completeSystemPath + File.separator + dbFileName;

    public String getFrameIconPath() {
        return completeLogoPath;
    }

    public String getDBCompletePath() {
        return completeDBPath;
    }

    public FileSystemManager() {
        // check sanity of folders

        File folder = new File(completeSystemPath);
        //System.out.println(folder);
        folder.mkdirs();

        folder = new File(completeRawPath);
        folder.mkdirs();

    }

    public void copyFile(File in, File out) {
        try {
            FileChannel inChannel = new FileInputStream(in).getChannel();
            FileChannel outChannel = new FileOutputStream(out).getChannel();

            inChannel.transferTo(0, inChannel.size(),
                    outChannel);

            inChannel.close();
            outChannel.close();
        } catch (Exception ex) {
            System.err.println("Error while copying..." + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileSystemManager n = new FileSystemManager();
    }

    public File getProfilePictureObject(String filename) {
        File target = new File(completeRawPath, filename);

        return target;
    }

    public File getFileObject(String filename) {
        File target = new File(completeSystemPath, filename);

        return target;
    }

    public boolean clearAllProfile() {
        boolean stat = false;
        File target = new File(completeProfilePath);
        if (target.exists()) {
            target.delete();
            stat = true;
        }

        return stat;
    }

    public ArrayList<Profile> getAllProfiles() {
        ArrayList<Profile> dataProf = new ArrayList<Profile>();

        String val = null;
        try {
            File myObj = new File(completeProfilePath);

            if (myObj.exists()) {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    val = myReader.nextLine();

                    // all data here is semi-colon separated values
                    // myWriter.write(prof.getTitle() + ";" + prof.getAddress() + ";" + prof.getPicture().getName() + "\n");
                    if (val.length() > 0) {
                        String data[] = val.split(";");
                        Profile single = new Profile();

                        single.setSelected(Boolean.valueOf(data[0]));
                        single.setCompanyName(data[1]);
                        single.setTitle(data[2]);
                        single.setAddress(data[3]);
                        single.setPicture(this.getProfilePictureObject(data[4]));

                        dataProf.add(single);
                    }
                    //System.out.println(data);
                }

                myReader.close();
            }

        } catch (Exception ex) {
            System.err.println("Error occurred when reading file profile selected! " + ex.getMessage());
            ex.printStackTrace();
        }

        return dataProf;
    }

    public Profile readProfileSelected() {
        Profile data = null;
        try {
            File myObj = new File(completeProfilePath);

            if (myObj.exists()) {
                String valTerbaca = null;
                String valOverall [] = null;
                
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    valTerbaca = myReader.nextLine();
                    data = new Profile();
                    
                    valOverall = valTerbaca.split(";");
                    
                    data.setSelected(Boolean.valueOf(valOverall[0]));
                    data.setCompanyName(valOverall[1]);
                    data.setTitle(valOverall[2]);
                    data.setAddress(valOverall[3]);
                    data.setPicture(getProfilePictureObject(valOverall[4]));
                    
                    break;
                }

                myReader.close();
            }

        } catch (Exception ex) {
            System.err.println("Error occurred when reading file profile selected! " + ex.getMessage());
            ex.printStackTrace();
        }

        return data;
    }

    public void saveProfile(ArrayList<Profile> dataIn) {

        try {
            FileWriter myWriter = new FileWriter(completeProfilePath);
            for (Profile prof : dataIn) {
                myWriter.write(prof.isSelected() +";" 
                        + prof.getCompanyName() + ";" 
                        + prof.getTitle() + ";" 
                        + prof.getAddress() + ";" 
                        + prof.getPicture().getName() + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote profile data!");
        } catch (Exception ex) {
            System.err.println("An error occurred " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
