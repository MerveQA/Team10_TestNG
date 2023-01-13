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
import utilities.TestBaseReports;

public class AmazonTest extends TestBaseReports {

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
    //  o Arama sonuçları sayfasından 2. sayfa açılır.                       --> DONE
    //  o 2. sayfanın açıldığı kontrol edilir.                               --> DONE
    //  o Sayfadaki 2. ürün favorilere eklenir.                              --> DONE
    //  o 2. Ürünün favorilere eklendiği kontrol edilir.                     --> DONE
    //  o Hesabım > Favori Listem sayfasına gidilir.                         --> DONE
    //  o “Favori Listem” sayfası açıldığı kontrol edilir.                   --> DONE
    //  o Eklenen ürün favorilerden silinir.                                 --> DONE
    //  o Silme işleminin gerçekleştiği kontrol edilir.                      --> DONE
    //  o Üye çıkış işlemi yapılır.                                          --> DONE
    //  o Çıkış işleminin yapıldığı kontrol edilir.                          --> DONE

    @Test
    public void test() {

        // Raporlama için oblemizi ekliyoruz
        extentTest = extentReports.createTest("amazonTest");

        //  o https://www.amazon.com.tr/ sitesi açılır.
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest = extentReports.createTest("Amazon Sitesi Açıldı");

        //  o Ana sayfanın açıldığı kontrol edilir.
        String homePageUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("url");
        ReasubleMethods.pageControl(expectedUrl, homePageUrl);
        extentTest = extentReports.createTest("Ana Sayfanın Açıldığı Kontrol Edildi");

        //  o Çerez tercihlerinden Çerezleri kabul et seçilir.
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.cookieAccept.click();
        extentTest = extentReports.createTest("Çerez Tercihlerinden Çerezler Kabul Edildi");

        //  o Siteye login olunur.
        ReasubleMethods.moveToElement(amazonPage.login);
        amazonPage.login.click();
        AmazonLoginPage alp = new AmazonLoginPage();
        ReasubleMethods.sendKey(ConfigReader.getProperty("email"), alp.txtEmail);
        alp.continueButton.click();
        ReasubleMethods.sendKey(ConfigReader.getProperty("password"), alp.txtPassword);
        alp.girisButton.click();
        extentTest = extentReports.createTest("Siteye Kullanıcı Bilgileriyle Login Olundu");

        // contain methodu eklenebilir
        // public static void icerirMi(WebElement iceriyorMu,String aranan){
        //     Assert.assertTrue(iceriyorMu.getText().contains(aranan));
        // }
        Assert.assertTrue(alp.inLogin.getText().contains("Merve"));
        extentTest = extentReports.createTest("Login İşlemi Kontrol Edildi");

        //  o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        ReasubleMethods.dropDown(alp.category).selectByVisibleText("Bilgisayarlar");
        extentTest = extentReports.createTest("Bilgisayarlar Kategorisi Seçildi");

        //  o Bilgisayar kategorisi seçildiği kontrol edilir.
        WebElement drop = ReasubleMethods.dropDown(alp.category).getFirstSelectedOption();
        ReasubleMethods.assertAssertTrue("Bilgisayarlar", drop);
        extentTest = extentReports.createTest("Bilgisayar Kategorisi Seçildiği Kontrol Edildi");

        // o Arama alanına MSI yazılır ve arama yapılır.
        ReasubleMethods.sendKey("MSI", alp.searchBox);
        alp.searchBox.sendKeys(Keys.ENTER);
        extentTest = extentReports.createTest("MSI Araması Yapıldı");

        // o Arama yapıldığı kontrol edilir.
        ReasubleMethods.assertAssertTrue("MSI", alp.search);
        extentTest = extentReports.createTest("MSI Araması Yapıldığı Kontrol Edildi");

        //  o Arama sonuçları sayfasından 2. sayfa açılır.
        ReasubleMethods.javaScrptExectr(alp.pageTwo);
        extentTest = extentReports.createTest("İkinci Sayfaya Geçildi");

        //  o 2. sayfanın açıldığı kontrol edilir.
        String pageCuurentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(pageCuurentUrl.contains("page=2"));
        extentTest = extentReports.createTest("İkinci Sayfanın Açıldığı Kontrol Edildi");

        //  o Sayfadaki 2. ürün favorilere eklenir.
        alp.productTwo.click();
        alp.addTwoKist.click();
        extentTest = extentReports.createTest("İkinci Sayfadan İkinci Ürün Favorilere Eklendi");

        //2. Ürünün favorilere eklendiği kontrol edilir.
        ReasubleMethods.assertAssertTrue("1 ürün şuraya eklendi:", alp.wishList);
        extentTest = extentReports.createTest("Ürünün Eklendiği Kontrol Edildi");

        //  o Hesabım > Favori Listem sayfasına gidilir.
        alp.favoriteListButton.click();
        extentTest = extentReports.createTest("Favori Listem Sayfasına Gidildi");

        //  o “Favori Listem” sayfası açıldığı kontrol edilir.
        String homepageUrl1 = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(homepageUrl1.contains("wishlist"));
        extentTest = extentReports.createTest("Favori Listem Sayfasının Açıldığı Kontrol Edildi");

        //  o Eklenen ürün favorilerden silinir.
        alp.deleteButon.click();
        extentTest = extentReports.createTest("Ürün Favorilerden Silindi");

        //  o Silme işleminin gerçekleştiği kontrol edilir.
        Assert.assertTrue(alp.silindi.isDisplayed());
        extentTest = extentReports.createTest("Silme İşleminin Gerçekleştiği Kontrol Edildi");

        //  o Üye çıkış işlemi yapılır.
        ReasubleMethods.moveToElement(amazonPage.login);
        alp.exitbutton.click();
        extentTest = extentReports.createTest("Üye Çıkış İşlemi Yapıldı");

        //  o Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertTrue(alp.girisButton.isDisplayed());
        extentTest = extentReports.createTest("Çıkış İşleminin Yapıldığı Kontrol Edili");

        // Browser kapatıldı
        Driver.closeDriver();
        extentTest = extentReports.createTest("Browser Kapatıldı");
    }
}
