package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static void javaScrptExectr(WebElement locator){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click()" ,locator);
    }
    public static String getScreenshot(WebDriver driver, String name) throws IOException {

        // Screenshot dosya ismi icin suanki tarihi String olarak aliyoruz.
        String date = formatCurrentDate(" yyyy.MM.dd_HH.mm.ss"); // asagida olusturdugumuz methodu kullandik.

        // Screenshot alip file objesine atiyoruz.
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Kaydedilecek dosyanin yolunu belirtiyoruz.
        String target = System.getProperty("user.dir")+ "\\test-output\\screenshot\\"+name+date+".png";

        File targetFile = new File(target);
        FileUtils.copyFile(source,targetFile);

        return target;
    }

    public static String formatCurrentDate(String pattern){

        return new SimpleDateFormat(pattern).format(new Date());
    }
}
