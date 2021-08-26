package com.tools.persistence;

import java.io.*;
import java.util.Properties;

public class PropertyFileReader {
        public static String getEnvConstantsItem(String key){
            String value="";
            String path = "src/main/resources/qa2-env/environmentConstants.properties";
            Properties properties = new Properties();
            InputStream inputStream = null;

            try{
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
                value = properties.getProperty(key);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return value;
        }
}
