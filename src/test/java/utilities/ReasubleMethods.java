package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ReasubleMethods {

    public static void pageControl(String expectedUrl , String actualUrl) {
       Assert.assertEquals(expectedUrl,actualUrl);
    }

    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void sendKey(String key,WebElement element) {
        element.sendKeys(key);
    }
}
