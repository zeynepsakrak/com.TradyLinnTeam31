package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_15_16_Page {
    public US_15_16_Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //US15_01_02_03
    @FindBy(xpath = "//li[@id='menu-item-1074']//a[contains(text(),'Hesabım')]")
    public WebElement myAccount;

    @FindBy(xpath = "//span[contains(text(),'Giriş Yap')]")
    public WebElement giris;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//a[normalize-space()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//a[@class='wcfm_menu_item '])[5]")
    public WebElement coupons;

    @FindBy(xpath = "//a[@id='add_new_coupon_dashboard']")
    public WebElement addNew;

    @FindBy(xpath = "(//div[@id='coupons_manage_limit'])[1]")
    public WebElement limit;

    @FindBy(xpath = "//input[@id='usage_limit']")
    public WebElement usageLimitCoupon;

    @FindBy(xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement usLimitItems;

    @FindBy(xpath = "//input[@id='usage_limit_per_user']")
    public WebElement perUser;


    // US16_01_02_03
    @FindBy(xpath = "//span[contains(text(),'müşteriler')]")
    public WebElement customers;

    @FindBy(xpath = "//td[@class='dataTables_empty']")
    public WebElement sonSiparis;


    @FindBy(xpath = "//span[contains(text(),'Yeni ekle')]")
    public WebElement newCustomers;

    @FindBy(xpath = "//input[@id='user_name']")
    public WebElement newUsername;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement newEmail;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement newName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement newLastname;

    @FindBy(xpath = "//input[@id='wcfm_customer_submit_button']")
    public WebElement submit;

    @FindBy(xpath = "//span[normalize-space()='Print']")
    public WebElement printButon;

    @FindBy(xpath = "//span[normalize-space()='Excel']")
    public WebElement excelButon;

    @FindBy(xpath = "//span[normalize-space()='CSV']")
    public WebElement csaButon;

}


