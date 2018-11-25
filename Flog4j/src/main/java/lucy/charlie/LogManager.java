package lucy.charlie;

import lucy.charlie.helper.Loader;
import lucy.charlie.helper.OptionConverter;

import java.net.URL;

public class LogManager {
    static public final String DEFAULT_CONFIGURATION_FILE = "flog4j.properties";

    static {
        URL url = Loader.getResource(LogManager.DEFAULT_CONFIGURATION_FILE);
            System.out.println("url: " + url);
            PropertyConfigurator propertyConfigurator = new PropertyConfigurator();
        propertyConfigurator.doConfigure(url);
    }

    public
    static
    Logger getLogger(final String name) {
        // Delegate the actual manufacturing of the logger to the logger repository.
        return null;
    }


}
