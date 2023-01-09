package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonLoginPage {

    public AmazonLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="ap_email")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@class='a-button-input']")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[@class='a-button-input']")
    public WebElement girisButton;

    @FindBy(xpath = "//span[@id='glow-ingress-line1']")
    public WebElement inLogin;

    @FindBy(xpath = "//select[@name='url']")
    public WebElement category;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement search;
}
