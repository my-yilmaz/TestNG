package tests.day17_pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroBankPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class C07_SoftAssert {
    ZeroBankPage zeroBankPage = new ZeroBankPage();

    @Test
    public void test01() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        zeroBankPage.signIn.click();
        // 3. Login kutusuna “username” yazin
        zeroBankPage.loginKutusu.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        zeroBankPage.passwordKutusu.sendKeys("password");
        // 5. hesaba girmek için Sign in tusuna basin
        zeroBankPage.hesapSignInButonu.click();
        Driver.getDriver().navigate().back();
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Pay Bills']")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        Driver.getDriver().findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = Driver.getDriver().findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String secilenOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (euro)";
        softAssert.assertEquals(secilenOption, expectedOption, "secilen option uygun degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
        // "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> optionList = select.getOptions();
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)",
                "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
                "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));
        List<String> actualList = optionList.stream().map(WebElement::getText).collect(Collectors.toList());
        Collections.sort(expectedList);
        Collections.sort(actualList);
        softAssert.assertEquals(actualList, expectedList, "secilen optionslar aynı");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}