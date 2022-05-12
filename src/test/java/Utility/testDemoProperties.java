package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class testDemoProperties {
    static  String uName;
    static String uPass;
    static  String wrong_pass;
    static  String  Country;
    static String Address;
    static  String Email;
    static  String PhoneNumber;

    static Properties prop;
        static {
            try {
                prop = readPropertiesFile("/Users/shilp/javaprg/MobileTestingFramework/src/main/resources/config.properties");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    public static String  getUsername_testdemo() {
        uName = prop.getProperty("username_testDemo");
      //  System.out.println("[Username]" + uName);
        return uName;
    }

    public static String  getCountry(){
        Country = prop.getProperty("country");
        return Country;
    }

    public static String  getAddress() {
        Address = prop.getProperty("address");
        return Address;
    }

    public static String  getEmail(){
        Email = prop.getProperty("email");
        return Email;
    }

    public static String  getPhoneNumber() {
        PhoneNumber = prop.getProperty("phonenumber");
        return PhoneNumber;
    }
    public static String  getPassword_testdemo() {
        uPass = prop.getProperty("password_testDemo");
       // System.out.println("[Password]" + uPass);
        return uPass;
    }

    public static String  getwrongPassword_testdemo() {
        wrong_pass = prop.getProperty("wrongpassword_testDemo");
        // System.out.println("[Password]" + uPass);
        return wrong_pass;
    }
    public static String getPath(){
            return prop.getProperty("reportConfigPath");
    }

    private static Properties readPropertiesFile(String s) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(s);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

}
