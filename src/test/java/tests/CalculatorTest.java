package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class CalculatorTest extends BaseTestClass {

	CalculatorPage cp;

	@BeforeMethod
	public void setupPage()
	{
		cp = new CalculatorPage(driver);
		cp.clearScreen();
	}

	@Test
	public void verifyAddition()
	{
		double result = Double.parseDouble(cp.add(11, 10));
		Assert.assertEquals(result, 21.0);
	}

	@Test
	public void verifySubtract()
	{
		double result = Double.parseDouble(cp.subtract(20, 5));
		Assert.assertEquals(result, 15.0);
	}

	@Test
	public void verifyMultiplication()
	{
		double result = Double.parseDouble(cp.multiply(5, 5));
		Assert.assertEquals(result, 25.0);
	}

	@Test
	public void verifyDivision()
	{
		double result = Double.parseDouble(cp.divide(10, 4));
		Assert.assertEquals(result, 2.5);
	}
	
	@Test
	public void verifyDivideByZero()
	{
	    String result = cp.divide(10, 0);
	    Assert.assertEquals(result, "Infinity");
	}



}
