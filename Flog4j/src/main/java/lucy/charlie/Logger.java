package lucy.charlie;

public class Logger {

    static
    public
    Logger getLogger(Class clazz) {
        return LogManager.getLogger(clazz.getName());
    }
}
