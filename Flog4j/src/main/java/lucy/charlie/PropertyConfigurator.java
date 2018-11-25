package lucy.charlie;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URLConnection;
import java.util.Properties;

public class PropertyConfigurator {
    static final String ROOT_LOGGER_PREFIX   = "log4j.rootLogger";

    public
    void doConfigure(java.net.URL configURL){
        Properties props = new Properties();
        LogLog.debug("Reading configuration from URL " + configURL);
        InputStream istream = null;
        URLConnection uConn = null;
        try {
            uConn = configURL.openConnection();
            uConn.setUseCaches(false);
            istream = uConn.getInputStream();
            props.load(istream);
        }
        catch (Exception e) {
            if (e instanceof InterruptedIOException || e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not read configuration file from URL [" + configURL
                    + "].", e);
            LogLog.error("Ignoring configuration file [" + configURL +"].");
            return;
        }
        finally {
            if (istream != null) {
                try {
                    istream.close();
                } catch(InterruptedIOException ignore) {
                    Thread.currentThread().interrupt();
                } catch(IOException ignore) {
                } catch(RuntimeException ignore) {
                }
            }
        }

    }
}
