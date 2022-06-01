package tests.day19_smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class D19_HotelRoomCreation {
    //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation


    HotelmycampPage htlPage = new HotelmycampPage();

    @Test
    public void roomCreateTest() throws InterruptedException {
        //2. Bir metod olusturun: RoomCreateTest()
        //3. https://www.hotelmycamp.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        htlPage.logIn.click();
        //a. Username : manager b. Password : Manager1!
        htlPage.username.sendKeys(ConfigReader.getProperty("hotelUsername"));
        htlPage.password.sendKeys(ConfigReader.getProperty("HotelPassword"));
        //5. Login butonuna tıklayın.
        htlPage.submitButonu.click();
        //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        htlPage.hotelManagement.click();
        htlPage.hotelRooms.click();
        htlPage.addHotelRoom.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8. Save butonuna basin.
        Select select = new Select(htlPage.selectHotel);
        Actions actions = new Actions(Driver.getDriver());
        select.selectByVisibleText("Star Hotel");
        actions.sendKeys(Keys.TAB)
                .sendKeys("3541")
                .sendKeys(Keys.TAB)
                .sendKeys("MY")
                .sendKeys(Keys.TAB)
                .sendKeys("Mars")
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("200")
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Select slct = new Select(htlPage.selectRoomType);
        slct.selectByVisibleText("Single");
        actions.sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("0")
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        htlPage.onayKutusu.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        htlPage.saveButonu.click();
        //9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        Assert.assertTrue(htlPage.saveText.isDisplayed());
        Thread.sleep(1000);
        //10. OK butonuna tıklayın.
        htlPage.cookieOkButonu.click();
        actions.sendKeys(Keys.PAGE_UP)
                .sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        //11. Hotel rooms linkine tıklayın.
        htlPage.hotelRoomsLink.click();
        Thread.sleep(1000);
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın.
        Assert.assertTrue(htlPage.listOfHotelRoomsText.isDisplayed());
        Driver.closeDriver();
    }
}
