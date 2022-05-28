package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroBankPage {
    public  ZeroBankPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "signin_button")
    public WebElement signIn;

    @FindBy (xpath = "//input[@name='user_login']")
    public WebElement loginKutusu;

    @FindBy (xpath = "//input[@id='user_password']")
    public WebElement passwordKutusu;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement hesapSignInButonu;
}
