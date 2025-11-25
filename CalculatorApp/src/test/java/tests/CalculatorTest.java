package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class CalculatorTest extends BaseTest {
    private CalculatorPage calculatorPage;

    @Test(priority = 1, description = "Test addition operation")
    public void testAddition() {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clear();
        
        calculatorPage.enterNumber("5");
        calculatorPage.performOperation("+");
        calculatorPage.enterNumber("3");
        calculatorPage.performOperation("=");
        
        Assert.assertEquals(calculatorPage.getResult(), "8", "Addition test failed");
    }
    
    @Test(priority = 2, description = "Test subtraction operation")
    public void testSubtraction() {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clear();
        
        calculatorPage.enterNumber("10");
        calculatorPage.performOperation("-");
        calculatorPage.enterNumber("4");
        calculatorPage.performOperation("=");
        
        Assert.assertEquals(calculatorPage.getResult(), "6", "Subtraction test failed");
    }
    
    @Test(priority = 3, description = "Test multiplication operation")
    public void testMultiplication() {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clear();
        
        calculatorPage.enterNumber("6");
        calculatorPage.performOperation("×");
        calculatorPage.enterNumber("7");
        calculatorPage.performOperation("=");
        
        Assert.assertEquals(calculatorPage.getResult(), "42", "Multiplication test failed");
    }
    
    @Test(priority = 4, description = "Test division operation")
    public void testDivision() {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clear();
        
        calculatorPage.enterNumber("20");
        calculatorPage.performOperation("÷");
        calculatorPage.enterNumber("5");
        calculatorPage.performOperation("=");
        
        Assert.assertEquals(calculatorPage.getResult(), "4", "Division test failed");
    }
    
    @Test(priority = 5, description = "Test decimal operations")
    public void testDecimalOperations() {
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.clear();
        
        calculatorPage.enterNumber("10.5");
        calculatorPage.performOperation("+");
        calculatorPage.enterNumber("2.5");
        calculatorPage.performOperation("=");
        
        Assert.assertEquals(calculatorPage.getResult(), "13", "Decimal addition test failed");
    }
}