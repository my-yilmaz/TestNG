package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    AmazonPage amazonPage=new AmazonPage();
    @Test
    public void test01() {

        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        String actualSonuc=amazonPage.aramaSonucElementi.getText();
        String expectedSonuc="nutella";
        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
        Driver.closeDriver();
    }
}
