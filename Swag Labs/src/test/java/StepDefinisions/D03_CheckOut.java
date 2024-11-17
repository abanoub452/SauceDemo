package StepDefinisions;

import Pages.P01_Login;
import Pages.P02_SwagLabsHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.text.ParseException;


public class D03_CheckOut {
    P01_Login login=new P01_Login();
    P02_SwagLabsHome checkOut =new P02_SwagLabsHome();
    String productName,productDescription;

    @Given("Login With {string}")
    public void openProductPage(String user){
        login.userName.sendKeys(user);
        login.password.sendKeys("secret_sauce");
        login.loginBtn.click();}
    @Given("open cart after add item to cart")
    public void openCart(){
        productName=checkOut.productName.getText();
        productDescription= checkOut.productDescription.getText();
        checkOut.addToCart.click();
        Assert.assertEquals(checkOut.numOfItemCart.getText(),"1");
        checkOut.shoppingCartLink.click();

    }
    @When("click checkout Button")
    public void clickOnCheckoutBtn(){
        checkOut.checkoutBtn.click();
    }
    @And("Enter first name {string}")
    public void enterFirstName(String name){
        checkOut.firstName.sendKeys(name);
    }
    @And("Enter last name {string}")
    public void enterLastName(String name){
        checkOut.lastName.sendKeys(name);
    }
    @And("Enter postal code {string}")
    public void enterpostalCode(String name){
        checkOut.postalCode.sendKeys(name);
    }
    @And("click on continue button")
    public void continueBtn(){
        checkOut.continueBtn.click();
    }
    @And("Check order details")
    public void checkOrderDetails() throws ParseException {
        String inventoryItemName = null,inventoryItemDesc=null;
        try {
            inventoryItemName = checkOut.inventoryItemName.getText();
            inventoryItemDesc  = checkOut.inventoryItemDesc.getText();
            Assert.assertEquals(inventoryItemName,productName);
            Assert.assertEquals(inventoryItemDesc,productDescription);
        } catch (Exception e){

            System.out.println("No item founded");
        }
        String priceText = checkOut.subtotal.getText();
        String[] myArray = priceText.split("\\$");
        priceText=myArray[myArray.length-1];
        double price ;
        try {
            price=Double.parseDouble(priceText);
        }catch (NumberFormatException e) {
            price=0;
        }
        System.out.println(price);
        String tax =checkOut.tax.getText();
        String[] taxArray = tax.split("\\$");
        tax=taxArray[taxArray.length-1];
        double taxamount;
        try {
            taxamount=Double.parseDouble(tax);
        }catch (NumberFormatException e) {
            taxamount=0;
        }
        String finalPrice = checkOut.total.getText();
        String[] finalPriceArray = finalPrice.split("\\$");
        finalPrice=finalPriceArray[finalPriceArray.length-1];
        double total;
        try {
            total=Double.parseDouble(finalPrice);
        }catch (NumberFormatException e) {
            total=0;
        }
        System.out.println(total);
        double totalPrice = price+taxamount;
        System.out.println(totalPrice);
        Assert.assertEquals(total,totalPrice,0.01);
    }
    @And("click on finish Button")
    public void clickFinishBtn(){
        checkOut.finishBtn.click();
    }
    @Then("confirmation message is display")
    public void confirmationMessage(){
        String confirmMessage = checkOut.confirmationOrderMessage.getText();
        Assert.assertEquals("Thank you for your order!",confirmMessage);
    }
    //Second Scenario
    @Given("open cart Without add item")
    public void openCartWithoutAddItem(){
        checkOut.shoppingCartLink.click();
    }

}

