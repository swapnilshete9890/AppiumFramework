package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage {

	AndroidDriver driver;
	WebDriverWait wait;

	public CalculatorPage(AndroidDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	//capture result
	@FindBy(id="com.bak.mnr.calculatrice:id/Cadre")
	WebElement resultText;

	//plus sign '+'
	@FindBy(id="com.bak.mnr.calculatrice:id/btnP")
	WebElement plus_sign;

	//multiplication sign
	@FindBy(id="com.bak.mnr.calculatrice:id/btnMult")
	WebElement mul_sign;

	//division sign
	@FindBy(id="com.bak.mnr.calculatrice:id/btnDiv")
	WebElement div_sign;

	//substract sign
	@FindBy(id="com.bak.mnr.calculatrice:id/btnS")
	WebElement sub_sign;

	//eql sign '='
	@FindBy(id="com.bak.mnr.calculatrice:id/btnE")
	WebElement eql_sign;
	
	//clear button
	@FindBy(id="com.bak.mnr.calculatrice:id/btnC")
	WebElement clearBtn;


	public void clickPlus()
	{
		plus_sign.click();
	}
	
	public void clickMinus()
	{
		sub_sign.click();
	}
	
	public void clickMul()
	{
		mul_sign.click();
	}
	
	public void clickDiv()
	{
		div_sign.click();
	}
	
	public void clickEquals()
	{
		eql_sign.click();
	}

	public String getResultText()
	{
		wait.until(ExpectedConditions.visibilityOf(resultText));
		return resultText.getText();
	}
	
	public void pressDigit(int digit) 
	{
	    driver.findElement(By.id("com.bak.mnr.calculatrice:id/btn" + digit)).click();
	}

	public void typeNumber(int number)
	{
	    // convert number to string
	    String value = String.valueOf(number);

	    // loop through each digit
	    for (char ch : value.toCharArray())
	    {
	        // convert char to int
	        int digit = Character.getNumericValue(ch);

	        // click digit
	        pressDigit(digit);
	    }
	}

	public String add(int a, int b)
	{
	    typeNumber(a);      // type first number
	    clickPlus();        // click +
	    typeNumber(b);      // type second number
	    clickEquals();   // click =

	    return getResultText();  // read and return result
	}

	public String subtract(int a, int b)
	{
		typeNumber(a);
		clickMinus();
		typeNumber(b);
		clickEquals();
		
		return getResultText();
	}
	
	public String multiply(int a, int b)
	{
		typeNumber(a);
		clickMul();
		typeNumber(b);
		clickEquals();
		
		return getResultText();
	}

	public String divide(int a, int b)
	{
		typeNumber(a);
		clickDiv();
		typeNumber(b);
		clickEquals();
		
		return getResultText();
	}
	
	public void clearScreen()
	{
		clearBtn.click();
	}









}
