package TestWatcher;

import Extentions.DemoStoreExtentions;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;

/**
 * A custom implementation of the JUnit 5 TestWatcher interface
 * that provides hooks for monitoring the status of tests.
 * <p>
 * This class implements various methods to handle test outcomes,
 * such as successful, failed, aborted, and disabled tests.
 * </p>
 */
public class TestWatcherTest extends DemoStoreExtentions implements org.junit.jupiter.api.extension.TestWatcher {

    /**
     * Invoked when a test is successful.
     *
     * @param context the context for the test that was successful
     */
    @Override
    public void testSuccessful(ExtensionContext context) {
        WriteToLog("Test '" + context.getDisplayName() + "' was successful.");
    }

    /**
     * Invoked when a test fails.
     *
     * @param context the context for the test that failed
     * @param cause the throwable that caused the test to fail
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        WriteToLog("Test '" + context.getDisplayName() + "' failed. Reason: " + cause.getMessage());
    }

    /**
     * Invoked when a test is aborted.
     *
     * @param context the context for the test that was aborted
     * @param cause the throwable that caused the test to be aborted
     */
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        WriteToLog("Test '" + context.getDisplayName() + "' was aborted. Reason: " + cause.getMessage());
    }

    /**
     * Invoked when a test is disabled.
     *
     * @param context the context for the test that was disabled
     * @param reason optional reason for why the test was disabled
     */
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        WriteToLog("Test '" + context.getDisplayName() + "' was disabled. Reason: " + reason.orElse("No reason provided"));
    }
}
