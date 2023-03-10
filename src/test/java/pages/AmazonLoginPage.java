package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonLoginPage {

    public AmazonLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ap_email")
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

    @FindBy(linkText = "2")
    public WebElement pageTwo;

    @FindBy(xpath = "//div[@data-index='2']")
    public WebElement productTwo;

    @FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
    public WebElement addTwoKist;

    @FindBy(xpath = "//span[text()='1 ürün şuraya eklendi:']")
    public WebElement wishList;

    @FindBy(linkText = "Listenizi Görüntüleyin")
    public WebElement favoriteListButton;

    @FindBy(name = "submit.deleteItem")
    public WebElement deleteButon;

    @FindBy(xpath = "//div[text()='Silindi']")
    public WebElement silindi;

    @FindBy(xpath = "//span[text()='Çıkış Yap']")
    public WebElement exitbutton;

    //  @FindBy(xpath= "//h1[@class='a-spacing-small']")
    //  public WebElement girisButon;


}
