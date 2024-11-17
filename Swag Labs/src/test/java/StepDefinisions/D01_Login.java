package StepDefinisions;

import Pages.P01_Login;
import Pages.P02_SwagLabsHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static StepDefinisions.Hooks.driver;

public class D01_Login {
    P01_Login login =new P01_Login();

    @Given("Open Login Page and Enter Valid User {string}")
    public void useruser(String useruser)
    {
        login.userName.sendKeys(useruser);
    }
    @When("Enter Password {string}")
    public void password(String Pass)
    {
        login.password.sendKeys(Pass);
    }
    @And("Click on Login Button")
    public void loginBtn()
    {
        login.loginBtn.click();
    }
    @Then("Enter To Home Page")
    public void loginSuccess()
    {
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }
    @Then("Login Failed")
    public void loginFailed()
    {
        String expectedUrl="https://www.saucedemo.com/";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }
    @And("Validation Error Message Is Displayed")
    public void validationMessage()
    {
        String expectedMessage="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expectedMessage,login.validationMessqage.getText());
    }
}

