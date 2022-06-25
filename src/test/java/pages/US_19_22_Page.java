package pages;

<<<<<<< HEAD
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_19_22_Page {
    public US_19_22_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='https://tradylinn.com/product-category/indirimli-urunler/'])[4]")
    public WebElement indirimliTumunuGor;

=======
public class US_19_22_Page {
>>>>>>> 2224abc (page)
}
