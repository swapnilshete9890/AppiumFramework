package cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CalculatorPage;
import tests.BaseTestClass;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CalculatorSteps extends BaseTestClass {
	
	CalculatorPage calculator;
	String actualResult;
	
	@Given("calculator app is launched")
	public void calculator_app_is_launched() 
	{
	    setup();   // reuse your existing Appium setup
	    calculator = new CalculatorPage(driver);
	}
	
	    @When("I add two numbers")
	    public void i_add_two_numbers() {
	        actualResult = calculator.add(2, 3);
	    }

	    @When("I multiply two numbers")
	    public void i_multiply_two_numbers() {
	        actualResult = calculator.multiply(4, 5);
	    }

	    @When("I divide a number by zero")
	    public void i_divide_a_number_by_zero() {
	        actualResult = calculator.divide(8, 0);
	    }

	    @Then("result should be displayed")
	    public void result_should_be_displayed() {
	        assertTrue(actualResult != null && !actualResult.isEmpty(),
	                "Result is not displayed");
	        calculator.clearScreen();
	    }
	    
	    @Then("error message should be displayed")
	    public void error_message_should_be_displayed() {
	        assertEquals(actualResult, "Infinity",
	                "Expected Infinity for divide by zero");
	        calculator.clearScreen();
	    }


}
