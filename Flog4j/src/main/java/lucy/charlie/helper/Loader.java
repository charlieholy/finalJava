package lucy.charlie.helper;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import lucy.charlie.LogManager;

public class Loader {
    static public URL getResource(String resource) {
        ClassLoader classLoader = null;
        URL url = null;
        try {
            classLoader = getTCL();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(classLoader != null) {

            url = classLoader.getResource(resource);
            if(url != null) {
                return url;
            }
        }
        return url;
    }
    /**
     * Get the Thread Context Loader which is a JDK 1.2 feature. If we
     * are running under JDK 1.1 or anything else goes wrong the method
     * returns <code>null<code>.
     *
     *  */
    private static ClassLoader getTCL() throws IllegalAccessException,
            InvocationTargetException {

        // Are we running on a JDK 1.2 or later system?
        Method method = null;
        try {
            method = Thread.class.getMethod("getContextClassLoader", null);
        } catch (NoSuchMethodException e) {
            // We are running on JDK 1.1
            return null;
        }

        return (ClassLoader) method.invoke(Thread.currentThread(), null);
    }

    static public Class loadClass (String clazz) throws ClassNotFoundException {
        // Just call Class.forName(clazz) if we are running under JDK 1.1
        if(false) {
            return Class.forName(clazz);
        } else {
            try {
                return getTCL().loadClass(clazz);
            }
            // we reached here because tcl was null or because of a
            // security exception, or because clazz could not be loaded...
            // In any case we now try one more time
            catch(InvocationTargetException e) {
                if (e.getTargetException() instanceof InterruptedException
                        || e.getTargetException() instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
            } catch(Throwable t) {
            }
        }
        return Class.forName(clazz);
    }

}
