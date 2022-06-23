package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_11_12_Page {

    public US_11_12_Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement urunlerButton;

}
