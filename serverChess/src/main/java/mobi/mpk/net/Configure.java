package mobi.mpk.net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configure {

    private static final String PROPERTIES_FILE = "/home/evgen/IdeaProjects/MyChess/serverChess/src/main/java/mobi/mpk/net/server.properties";

    public static int PORT;

    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;

        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);

            PORT             = Integer.parseInt(properties.getProperty("PORT"));

        } catch (FileNotFoundException ex) {
            System.err.println("Properties config file not found");
        } catch (IOException ex) {
            System.err.println("Error while reading file");
        } finally {
            try {
                propertiesFile.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
