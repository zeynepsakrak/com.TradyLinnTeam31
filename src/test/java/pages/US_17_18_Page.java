package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_17_18_Page {
    public US_17_18_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//li[@id='menu-item-1074']")
    public WebElement hesabim;

    @FindBy (xpath = "//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManager;

    @FindBy (xpath = "//span[@class='wcfmfa fa-user-circle']")
    public WebElement musteriler;

    @FindBy (xpath = "//span[@class='wcfmfa fa-user-plus']")
    public WebElement yeniMusteriEkle;

    @FindBy (id = "user_name")
    public WebElement musteriUserName;

    @FindBy (xpath = "//input[@id='user_name']")
    public WebElement usernameBox;

    @FindBy (xpath = "//input[@id='user_email']")
    public WebElement emailBox;

    @FindBy (xpath = "//input[@id='first_name']")
    public WebElement firstNameBox;

    @FindBy (xpath = "//input[@id='last_name']")
    public WebElement lastNameBox;

    @FindBy (xpath = "//input[@id='bfirst_name']")
    public WebElement billingFirstNameBox;

    @FindBy (xpath = "//input[@id='blast_name']")
    public WebElement billingLastNameBox;

    @FindBy (xpath = "//input[@id='bcompany_name']")
    public WebElement billingCompanyNameBox;

    @FindBy (xpath = "//input[@id='bphone']")
    public WebElement billingPhoneBox;

    @FindBy (xpath = "//input[@id='baddr_1']")
    public WebElement billingAddress1Box;

    @FindBy (xpath = "//input[@id='baddr_2']")
    public WebElement billingAddress2Box;

    @FindBy(id = "select2-bcountry-container")
    public WebElement billingCountry;

    @FindBy (id = "select2-bcountry-result-9kwe-TR")
    public WebElement Turkiye;

    @FindBy (xpath = "//input[@id='bcity']")
    public WebElement billingCityBox;

    @FindBy(xpath = "//select[@id='bstate']")
    public WebElement billingStateDropDown;

    @FindBy (xpath = "//input[@id='bzip']")
    public WebElement billingZipBox;

    @FindBy (xpath = "//input[@id='same_as_billing']")
    public WebElement checkBox;

    @FindBy (xpath = "//input[@id='sfirst_name']")
    public WebElement shippingFirstNameBox;

    @FindBy (xpath = "//input[@id='slast_name']")
    public WebElement shippingLastNameBox;

    @FindBy (xpath = "//input[@id='scompany_name']")
    public WebElement shippingCompanyNameBox;

    @FindBy (xpath = "//input[@id='saddr_1']")
    public WebElement shippingAddress1Box;

    @FindBy (xpath = "//input[@id='saddr_2']")
    public WebElement shippingAddress2Box;

    @FindBy (xpath = "//span[@id='select2-scountry-container']")
    public WebElement shippingCountryDropDown;

    @FindBy (xpath = "//input[@id='scity']")
    public WebElement shippingCityBox;

    @FindBy (xpath = "//input[@id='sstate']")
    public WebElement shippingStateBox;

    @FindBy (xpath = "//input[@id='szip']")
    public WebElement shippingZipBox;

    @FindBy (id = "wcfm_customer_submit_button")
    public WebElement submitButonu;

    @FindBy (xpath = "//span[@class='wcfmfa fa-retweet']")
    public WebElement refundButonu;







}
