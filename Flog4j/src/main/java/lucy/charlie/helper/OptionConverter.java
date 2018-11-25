package lucy.charlie.helper;

public class OptionConverter {
    public
    static
    String getSystemProperty(String key, String def) {
        try {
            return System.getProperty(key, def);
        } catch(Throwable e) { // MS-Java throws com.ms.security.SecurityExceptionEx
            //LogLog.debug("Was not allowed to read system property \""+key+"\".");
            return def;
        }
    }

    public
    static
    boolean toBoolean(String value, boolean dEfault) {
        if(value == null) {
            return dEfault;
        }
        String trimmedVal = value.trim();
        if("true".equalsIgnoreCase(trimmedVal)) {
            return true;
        }
        if("false".equalsIgnoreCase(trimmedVal)) {
            return false;
        }
        return dEfault;
    }
}
