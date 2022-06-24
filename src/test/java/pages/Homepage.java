package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homepage {
    public Homepage() {

            PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement girisButonu;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement pasword;

    @FindBy(xpath = "//button[@name=\"login\"]")
    public WebElement girisYapButonu;

    @FindBy(xpath = "(//a[@class='cart-toggle'])[1]")
    public WebElement sepetimIkonu;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement sepetiGoruntule;

    @FindBy(xpath = "//button[text()='Temizle']")
    public WebElement sepetiTemizle;

    @FindBy(xpath = "(//img[@alt='Tradylinn'])[1]")
    public WebElement tradylinnIkonu;
}
