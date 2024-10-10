package Extentions;

import org.junit.jupiter.api.extension.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * JUnit 5 extension that provides logging capabilities for tests.
 * This extension implements {@link BeforeAllCallback} and {@link ExtensionContext.Store.CloseableResource}
 * to handle logging before all tests and ensure that resources are closed after the tests.
 */
public class DemoStoreExtentions implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private Logger logger = Logger.getLogger("TestLogger");
    private FileHandler fileHandler;
    private static boolean isRun = false;

    /**
     * Callback that is invoked once before all tests in the current container.
     * It sets up logging to a file named "test.log" and ensures the setup is done only once per test run.
     *
     * @param context the current extension context; never {@code null}
     * @throws Exception if an error occurs during logging setup
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if (!isRun) {
            context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put("StartTests", this);

            try {
                // Specify the file path where the log file will be created
                fileHandler = new FileHandler("test.log");
                logger.addHandler(fileHandler);
                SimpleFormatter formatter = new SimpleFormatter();
                fileHandler.setFormatter(formatter);
            } catch (IOException e) {
                e.printStackTrace();
            }
            isRun = true;
        }
    }

    /**
     * Closes the resources used for logging.
     * This method is invoked after all tests are run to close the file handler and release the resources.
     *
     * @throws Throwable if an error occurs during resource closure
     */
    @Override
    public void close() throws Throwable {
        fileHandler.close();
    }

    /**
     * Writes a log entry with the specified information.
     *
     * @param info the information to log
     */
    public void WriteToLog(String info) {
        logger.info(info);
    }
}
