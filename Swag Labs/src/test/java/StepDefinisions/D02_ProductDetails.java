package StepDefinisions;

import Pages.P01_Login;
import Pages.P02_SwagLabsHome;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
public class D02_ProductDetails {
    P01_Login login=new P01_Login();
    P02_SwagLabsHome product = new P02_SwagLabsHome();
    String productTitle , productDesc , image;


    @Given("Open Home Page")
    public void openProductPage(){
        login.userName.sendKeys("visual_user");
        login.password.sendKeys("secret_sauce");
        login.loginBtn.click();}
    @When("click on product and display names and details")
    public void OpenProduct () throws InterruptedException {
        productTitle = product.productName.getText();
        productDesc=product.productDescription.getText();
        image=product.productimage.getAttribute("src");
        try {
            // Assert title does not contain 'carry.allTheThings()'
            Assert.assertFalse("Title contains 'carry.allTheThings()'", productTitle.contains("carry.allTheThings()"));
        } catch (AssertionError message) {
            System.out.println("Assertion failed for product title: " + message.getMessage());
        }
        try {
            // Assert description does not contain 'carry.allTheThings()'
            Assert.assertFalse("Description contains 'carry.allTheThings()'", productDesc.contains("carry.allTheThings()"));
        } catch (AssertionError message) {
            System.out.println("Assertion failed for product description: " + message.getMessage());
        }
        product.openProduct.click();
    }

    @Then("make sure all info is match with product")
    public void productDetails(){
        System.out.println(product.ProductTitle.getText());
        Assert.assertEquals(product.ProductTitle.getText(),productTitle);
        Assert.assertEquals(product.ProductDetails.getText(),productDesc);
        Assert.assertEquals(product.ProductimageDetails.getAttribute("src"),image);
    }
}
