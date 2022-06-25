package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_08_09_10_Page {
    public US_08_09_10_Page() {
        PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabim;

}
