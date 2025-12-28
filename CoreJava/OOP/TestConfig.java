package OOP;

/**
 * Example for real time scenario for SDET to user final keyword in class.
 * In automation, we often need configuration constants (like URLs, timeouts, browser names).
 * Final class can't extended so it prevents inheritance
 */
public final class TestConfig {
    // Constants for test environment
    public static final String BASE_URL = "https://qa.myapp.com";
    public static final int TIMEOUT_SECONDS = 30;
    public static final String BROWSER = "chrome";

    // Private constructor to prevent instantiation
    private TestConfig() {
        // no-op
    }
}
