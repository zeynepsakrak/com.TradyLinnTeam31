package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_05_06_07_Page {
    public US_05_06_07_Page () {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[@href='https://tradylinn.com/my-account-2/']")
    public WebElement hesabimButonu;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManagerButonu;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement urunButonu;

    @FindBy(xpath = "//th[@aria-label='Status']")
    public WebElement Status;

    @FindBy(xpath = "//th[@aria-label='Stock']")
    public WebElement Stock;

    @FindBy(xpath = "//*[@id=\"wcfm-products\"]/thead/tr/th[7]")
    public WebElement Price;

    @FindBy(xpath = "//th[@aria-label='Date: activate to sort column ascending']")
    public WebElement Date;





}
