package tests.day17_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.Driver;

public class C04_PageClassKullanimi {

    // 1 ) Bir Class olustur : PositiveTest
    // 2) Bir test method olustur positiveLoginTest()
HotelmycampPage hotelmycampPage=new HotelmycampPage();
    @Test
    public void positiveLoginTest() {
        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        // login butonuna bas
        hotelmycampPage.logIn.click();
        // test data username: manager
        hotelmycampPage.username.sendKeys("manager");
        // test data password : Manager1!
        hotelmycampPage.password.sendKeys("Manager1!");
        hotelmycampPage.submitButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement profilElementi=Driver.getDriver()
                .findElement(By.xpath("//span[@class='username username-hide-on-mobile']"));
        Assert.assertTrue(profilElementi.isDisplayed());
    }


}
