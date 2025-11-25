package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    
    private final By btn1 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01");
    private final By btn2 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02");
    private final By btn3 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03");
    private final By btn4 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_04");
    private final By btn5 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05");
    private final By btn6 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06");
    private final By btn7 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07");
    private final By btn8 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08");
    private final By btn9 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09");
    private final By btn0 = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00");
    private final By btnAdd = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add");
    private final By btnSubtract = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub");
    private final By btnMultiply = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul");
    private final By btnDivide = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div");
    private final By btnEquals = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal");
    private final By btnClear = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_clear");
    private final By resultField = By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula");
    private final By btnDot = By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_dot");

    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getResult() {
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(resultField));
        String fullText = result.getText().trim();
        return fullText.split(" ")[0]; 
    }

    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            switch (digit) {
                case '0' -> click(btn0);
                case '1' -> click(btn1);
                case '2' -> click(btn2);
                case '3' -> click(btn3);
                case '4' -> click(btn4);
                case '5' -> click(btn5);
                case '6' -> click(btn6);
                case '7' -> click(btn7);
                case '8' -> click(btn8);
                case '9' -> click(btn9);
                case '.' -> click(btnDot);
            }
        }
    }

    public void performOperation(String operation) {
        switch (operation) {
            case "+" -> click(btnAdd);
            case "-" -> click(btnSubtract);
            case "×" -> click(btnMultiply);
            case "÷" -> click(btnDivide);
            case "=" -> click(btnEquals);
        }
    }

    public void clear() {
        click(btnClear);
    }

    private void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println("Error clicking element: " + locator);
            e.printStackTrace();
        }
    }
}