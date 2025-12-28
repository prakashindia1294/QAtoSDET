package OOP;

/**
 * Declare class with abstract keyword
 * It can contains, abstract method(without body) as well as concrete method(with body)
 */
/*
When to use abstract class
1. you want to enforce a contract but also provide shared implementation.
2. you expect subclass to provide specific behaviour.
3. Interfaces alone aren’t enough because you need state (fields) or default logic.
 */
public abstract class BaseTest {

    // Common setup logic
    public void setUp() {
        System.out.println("Initializing WebDriver and opening browser...");
        // WebDriver driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Abstract method → must be implemented by subclasses
    public abstract void executeTest();

    // Common teardown logic
    public void tearDown() {
        System.out.println("Closing browser and cleaning up...");
        // driver.quit();
    }
}

class LoginTest extends BaseTest {

    @Override
    public void executeTest() {
        System.out.println("Executing Login Test...");
        // driver.get(TestConfig.BASE_URL);
        // driver.findElement(By.id("username")).sendKeys("prakash");
        // driver.findElement(By.id("password")).sendKeys("password123");
        // driver.findElement(By.id("loginBtn")).click();
    }

    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.setUp();
        test.executeTest();
        test.tearDown();
    }
}

