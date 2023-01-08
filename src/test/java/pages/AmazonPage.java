package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="sp-cc-accept")
    public WebElement cookieAccept;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    public WebElement login;


}
