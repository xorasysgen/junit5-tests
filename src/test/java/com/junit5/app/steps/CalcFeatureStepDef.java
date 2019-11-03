package com.junit5.app.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.junit5.app.java8.Calc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class CalcFeatureStepDef {
	
	Calc calc;
	Integer result;
	
  @Given("Create a calulator")
  public void given() throws Throwable {
	  calc=new Calc();
  }

  @When("Calulate (\\d+)")
  public void when(Integer number) throws Throwable {
	  result=calc.Calculator(number);
  }

  @Then("Result is 50")
  public void then() throws Throwable {
	  assertEquals(result, 50);
  }

}
