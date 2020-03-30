import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Logger was configured");
    }
}
