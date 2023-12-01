package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;

public class TestConfig
{
    public static HashMap<String, String> prjProperties = new HashMap<String, String>();

    public static HashMap<String, String> getConfigDetails()
    {
        try {
            String userDir = System.getProperty("user.dir");
            File fle = new File(userDir + "/src/test/resources/configurations/config.properties");
            FileInputStream fileInput = new FileInputStream(fle);

            Properties prop = new Properties();
            prop.load(fileInput);

            for (String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key);
                prjProperties.put(key, value);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return prjProperties;
    }
}
