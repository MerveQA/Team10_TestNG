package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ReasubleMethods {

    public static void pageControl(String expectedUrl, String actualUrl) {
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void sendKey(String key, WebElement element) {
        element.sendKeys(key);
    }

    public static Select dropDown(WebElement element) {
        Select select = new Select(element);

        return select;
    }

    public static void assertAssertTrue(String text, WebElement locator){
        Assert.assertTrue(locator.getText().contains(text));
    }

}
