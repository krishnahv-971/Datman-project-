package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    @BeforeClass
    public void setUp() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("Galaxy A16")
                    .setPlatformName("Android")
                    .setPlatformVersion("16")
                    .setAutomationName("UiAutomator2")
                    .setAppPackage("com.sec.android.app.popupcalculator")
                    .setAppActivity(".Calculator")
                    .setNoReset(true)
                    .setFullReset(false)
                    .setEnsureWebviewsHavePages(true)
                    .setNativeWebScreenshot(true)
                    .setNewCommandTimeout(Duration.ofSeconds(3600));

            driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            Thread.sleep(3000);
            
        } catch (Exception e) {
            System.out.println("Error initializing driver: " + e.getMessage());
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}