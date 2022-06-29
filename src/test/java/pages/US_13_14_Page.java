package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_13_14_Page {
    public US_13_14_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='menu-item-1074']")
    public WebElement hesabimButonu;

    @FindBy(xpath = "//p[@class='greeting mb-0']")
    public WebElement kullaniciAdiDogrulama;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement storeManagerButonu;

    @FindBy(xpath = "(//a[@class='wcfm_menu_item '])[5]")
    public WebElement kuponlarButonu;

    @FindBy(xpath = "//a[@id='add_new_coupon_dashboard']")
    public WebElement kuponlarYeniButonu;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement codeText;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement descriptionText;

    @FindBy(xpath = "//select[@id='discount_type']")
    public WebElement discountTypeText;

    @FindBy(xpath = "//input[@id='coupon_amount']")
    public WebElement couponAmountText;

    @FindBy(xpath = "//input[@id='expiry_date']")
    public WebElement couponexpirydateText;

    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement allowfreeshippingCheck;

    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement showonstoreCheck;

    @FindBy(xpath = "//div[@id='coupons_manage_restriction']")
    public WebElement restrictionButonu;

    @FindBy(xpath = "//input[@id='minimum_amount']")
    public WebElement minimumspendText;

    @FindBy(xpath = "//input[@id='maximum_amount']")
    public WebElement maximumspendText;

    @FindBy(xpath = "//input[@id='individual_use']")
    public WebElement IndividualuseonlyCheck;

    @FindBy(xpath = "//input[@id='exclude_sale_items']")
    public WebElement excludesaleitemsCheck;

    @FindBy(xpath = "//select[@id='exclude_product_categories']")
    public WebElement excludecategories;

    @FindBy(xpath = "//input[@id='wcfm_coupon_manager_submit_button']")
    public WebElement submitButonu;

    @FindBy(xpath = "//input[@id='wcfm_coupon_manager_draft_button']")
    public WebElement draftButonu;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
    public WebElement kayitEdildiMesage;

    @FindBy (xpath = "//*[text()='Coupon Successfully Published.']")
    public WebElement submitOnayYazisi;

    @FindBy(xpath = "//li[@class='select2-selection__choice']")
    public List<WebElement> categoriesSelectedList;

}
