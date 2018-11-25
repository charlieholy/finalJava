import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Slog4j {
    static final Logger logger = LoggerFactory.getLogger(Slog4j.class);

    public static void main(String[] args) {
        MDC.put("a","b");
        String ss = MDC.get("a");
        System.out.println("ss: " + ss);
        logger.info("{}","asasdd");
    }
}
