package tests;

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
  //  o Login işlemi kontrol edilir.
  //  o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
  //  o Bilgisayar kategorisi seçildiği kontrol edilir.
  //  o Arama alanına MSI yazılır ve arama yapılır.
  //  o Arama yapıldığı kontrol edilir.
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
        ReasubleMethods.sendKey("merveabd_61@hotmail.com",alp.txtEmail);
        alp.continueButton.click();
        ReasubleMethods.sendKey("9272462642",alp.txtPassword);
        alp.girisButton.click();



    }
}
