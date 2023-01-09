package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonLoginPage;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReasubleMethods;

public class AmazonTest {

  //  Amazon Senaryosu
  //  o https://www.amazon.com.tr/ sitesi açılır.                          --> DONE
  //  o Ana sayfanın açıldığı kontrol edilir.                              --> DONE
  //  o Çerez tercihlerinden Çerezleri kabul et seçilir.                   --> DONE
  //  o Siteye login olunur.                                               --> DONE
  //  o Login işlemi kontrol edilir.                                       --> DONE
  //  o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.    --> DONE
  //  o Bilgisayar kategorisi seçildiği kontrol edilir.                    --> DONE
  //  o Arama alanına MSI yazılır ve arama yapılır.                        --> DONE
  //  o Arama yapıldığı kontrol edilir.                                    --> DONE
  //  o Arama sonuçları sayfasından 2. sayfa açılır.
  //  o 2. sayfanın açıldığı kontrol edilir.
  //  o Sayfadaki 2. ürün favorilere eklenir.
  //          o 2. Ürünün favorilere eklendiği kontrol edilir.
  //  o Hesabım > Favori Listem sayfasına gidilir.
  //  o “Favori Listem” sayfası açıldığı kontrol edilir.
  //  o Eklenen ürün favorilerden silinir.
  //  o Silme işleminin gerçekleştiği kontrol edilir.
  //  o Üye çıkış işlemi yapılır.
  //  o Çıkış işleminin yapıldığı kontrol edilir.

    @Test
    public void test() {
        //  o https://www.amazon.com.tr/ sitesi açılır.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //  o Ana sayfanın açıldığı kontrol edilir.
        String homePageUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("url");
        ReasubleMethods.pageControl(expectedUrl,homePageUrl);
        //  o Çerez tercihlerinden Çerezleri kabul et seçilir.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.cookieAccept.click();
        //  o Siteye login olunur.
        ReasubleMethods.moveToElement(amazonPage.login);
        amazonPage.login.click();
        AmazonLoginPage alp = new AmazonLoginPage();
        ReasubleMethods.sendKey(ConfigReader.getProperty("email"),alp.txtEmail);
        alp.continueButton.click();
        ReasubleMethods.sendKey(ConfigReader.getProperty("password"),alp.txtPassword);
        alp.girisButton.click();

        // contain methodu eklenebilir
        // public static void icerirMi(WebElement iceriyorMu,String aranan){
        //     Assert.assertTrue(iceriyorMu.getText().contains(aranan));
        // }
        Assert.assertTrue(alp.inLogin.getText().contains("Merve"));

        //  o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        ReasubleMethods.dropDown(alp.category).selectByVisibleText("Bilgisayarlar");

        //  o Bilgisayar kategorisi seçildiği kontrol edilir.
        WebElement drop = ReasubleMethods.dropDown(alp.category).getFirstSelectedOption();
        ReasubleMethods.assertAssertTrue("Bilgisayarlar",drop);

        // o Arama alanına MSI yazılır ve arama yapılır.
        ReasubleMethods.sendKey("MSI",alp.searchBox);
        alp.searchBox.sendKeys(Keys.ENTER);

        // o Arama yapıldığı kontrol edilir.
        ReasubleMethods.assertAssertTrue("MSI",alp.search);




    }
}
