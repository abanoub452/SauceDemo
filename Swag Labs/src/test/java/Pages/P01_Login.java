package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static StepDefinisions.Hooks.driver;

public class P01_Login {
    public P01_Login(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    public WebElement userName;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    public WebElement validationMessqage;



}
