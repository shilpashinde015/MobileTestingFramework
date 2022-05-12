package Utility;


import java.io.*;
import java.util.Properties;

public class readProperties  {
   static  String uName;
   static String uPass;
    static Properties prop;

    static {
        try {
            prop = readPropertiesFile("/Users/shilp/javaprg/MobileTestingFramework/src/main/resources/config.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String  getUsername() {
       uName = prop.getProperty("username");
       System.out.println("[Username]" + uName);
       return uName;
     }

     public static String  getPassword() {
         uPass = prop.getProperty("password");
         System.out.println("[Password]" + uPass);
         return uPass;
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

