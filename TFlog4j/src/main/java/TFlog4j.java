import lucy.charlie.LogManager;
import lucy.charlie.helper.Loader;

import java.net.URL;

public class TFlog4j {
    public static void main(String[] args) {
        URL url = Loader.getResource(LogManager.DEFAULT_CONFIGURATION_FILE);
        System.out.println("url: " + url);
    }
}
