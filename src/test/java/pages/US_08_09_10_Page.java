package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_08_09_10_Page {
    public US_08_09_10_Page() {
        PageFactory.initElements(Driver.getDriver(),this); }
    @FindBy(xpath = " //input[@id='wcfm_products_simple_submit_button']")
    public WebElement Submit;

//*******us08******
    @FindBy(xpath = "//div[@id='wcfm_products_manage_form_inventory_head']")
    public WebElement Inventory;
    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement ManageStock;
    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement StockMiktar;
    @FindBy(xpath = "//select[@id='backorders']")
    public WebElement AllowBlackorder;
    @FindBy(xpath = "(//select[@id='backorders'])//option[3]")
    public WebElement Allow;
    @FindBy(xpath = "(//select[@id='backorders'])//option[2]")
    public WebElement AllowButNotifyCustomer;
    @FindBy(xpath = "(//select[@id='backorders'])//option[1]")
    public WebElement DoNotAllow;

//*******us09******
    @FindBy(xpath = "//div[contains(text(),'Shipping')]")
    public WebElement Shipping;
    @FindBy (xpath = "//input[@id=\"weight\"]")
    public WebElement Weight;
    @FindBy(xpath = "//input[@id='length']")
    public WebElement Length;
    @FindBy(xpath = "//input[@id='width']")
    public WebElement width;
    @FindBy(xpath = "//input[@id='height']")
    public WebElement height;
    @FindBy(xpath = "//select[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;
    @FindBy(xpath = "//*[contains(text(),'capacity')]")
    public WebElement hacim;

//*******us10******
    @FindBy(xpath = "//div[@class='page_collapsible_content_holder'][normalize-space()='Attributes']")
    public WebElement Attributes;
    @FindBy(xpath = "//input[@id='attributes_is_active_1']")
    public WebElement colorOk;
    @FindBy(xpath = "//select[@id='attributes_value_1']")
    public WebElement colorSelectAll;
    @FindBy(xpath = "//input[@id='attributes_is_active_2']")
    public WebElement sizeOk;
    @FindBy(xpath = "//select[@id='attributes_value_2']")
    public WebElement sizeSelectAll;


}
