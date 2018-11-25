import lucy.charlie.LogManager;
import lucy.charlie.Logger;
import lucy.charlie.RollingFileAppender;
import lucy.charlie.helper.Loader;

import java.net.URL;

public class TFlog4j {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TFlog4j.class);

        try {
            Class classObj = Loader.loadClass("lucy.charlie.RollingFileAppender");
            Object o = classObj.newInstance();
            ((RollingFileAppender)o).foo();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
