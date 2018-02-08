package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kaurmnd on 06/02/2018.
 */
public class GenericUtils {
    private static Properties propertyFile;

    private static String propertyFilename = System.getProperty("user.dir") + "/src/test/resources/Data.properties";

    public String getStringPropValue(String key) {
        Properties prop = new Properties();
        InputStream input = null;
        String result = "";
        try {
            prop.load(new FileInputStream(propertyFilename));
            result = prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    //Reporter.log("Error while reading config: " + e.getMessage(), 2, true);
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    }
