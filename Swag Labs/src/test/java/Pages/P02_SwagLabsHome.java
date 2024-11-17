package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static StepDefinisions.Hooks.driver;
public class P02_SwagLabsHome {
WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    // Constructor that accepts WebDriver to initialize PageFactory
    public P02_SwagLabsHome( ) {
        PageFactory.initElements(driver, this);
    }

     @FindBy(id = "item_4_img_link")
     public WebElement openProduct;
     @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
     public WebElement productName;

     @FindBy(className = "inventory_item_desc")
     public WebElement productDescription;
     @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
     public WebElement productimage;
//     @FindBy(className = "inventory_details_name")
    @FindBy(css = ".inventory_details_name.large_size")
    public WebElement ProductTitle;
     @FindBy(className = "inventory_details_desc")
     public WebElement ProductDetails;
     @FindBy(className = "inventory_details_img")
     public WebElement ProductimageDetails;
     @FindBy(id = "add-to-cart-sauce-labs-backpack")
     public WebElement addToCart;
     @FindBy(className = "shopping_cart_badge")
     public WebElement numOfItemCart;
     @FindBy(className = "shopping_cart_link")
     public WebElement shoppingCartLink;
     @FindBy(id = "checkout")
     public WebElement checkoutBtn;
     @FindBy(id = "first-name")
     public WebElement firstName;
    @FindBy(id = "last-name")
    public WebElement lastName;
    @FindBy(id = "postal-code")
    public WebElement postalCode;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(className = "inventory_item_name")
    public WebElement inventoryItemName;
    @FindBy(className = "inventory_item_desc")
    public WebElement inventoryItemDesc;
    @FindBy(id = "finish")
    public WebElement finishBtn;
    //Price
    @FindBy(className = "summary_subtotal_label")
    public WebElement subtotal;
    @FindBy(className = "summary_tax_label")
    public WebElement tax;
    @FindBy(className = "summary_total_label")
    public WebElement total;
    @FindBy(className = "complete-header")
    public WebElement confirmationOrderMessage;
    @FindBy(className = "product_sort_container")
    public WebElement sort;
    @FindBy(className = "inventory_item_price")
    public WebElement inventoryPriceEl;


}