package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelmycampPage {
    public HotelmycampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement logIn;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement submitButonu;

    @FindBy(linkText = "Hotel Management")
    public  WebElement hotelManagement;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[3]")
    public WebElement hotelRooms;

    @FindBy(className = "hidden-480")
    public  WebElement addHotelRoom;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement selectHotel;

    @FindBy(xpath = "//select[@id='IDGroupRoomType']")
    public WebElement selectRoomType;

    @FindBy(xpath = "//input[@id='IsAvailable']")
    public WebElement onayKutusu;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement saveButonu;
    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement saveText;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public WebElement cookieOkButonu;

    @FindBy(xpath = "//a[text()='Hotelrooms']")
    public WebElement hotelRoomsLink;

    @FindBy(xpath="//span[text()='List Of Hotelrooms']")
    public WebElement listOfHotelRoomsText;

}
