package StepDefinisions;

import Pages.P01_Login;
import Pages.P02_SwagLabsHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class D04_Filter {
    P01_Login login=new P01_Login();
    P02_SwagLabsHome filter =new P02_SwagLabsHome();
    @Given("Login With {string} and pass {string}")
    public void openProductPage(String user , String pass){
        login.userName.sendKeys(user);
        login.password.sendKeys(pass);
        login.loginBtn.click();}
    @When("select filter product with low pice to hight price")
    public void selectlowPrice(){
        Select sort= new Select(filter.sort);
        sort.selectByIndex(2);
        String inventoryPrice = filter.inventoryPriceEl.getText();
        String []array = inventoryPrice.split("\\$");
        inventoryPrice =array[array.length-1];
        double price = Double.parseDouble(inventoryPrice);
        assertEquals(7.99,price,.1);
    }
    @And("filter with high price to low price")
    public void selecthighPrice(){
        Select sort= new Select(filter.sort);
        sort.selectByIndex(3);
        String inventoryPrice = filter.inventoryPriceEl.getText();
        String []array = inventoryPrice.split("\\$");
        inventoryPrice =array[array.length-1];
        double price = Double.parseDouble(inventoryPrice);
        Assert.assertEquals(49.99,price,0.1);
    }
}


