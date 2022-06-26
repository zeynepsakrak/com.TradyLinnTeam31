package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US_08_09_10_Page;
import utilities.Driver;

import java.util.List;

import static tests.ReusableMethods.*;

public class US09 {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void testName(){
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Shipping.click();
        bekle();
    }
    /*
    US09_TC01 Kilo ve boyut belirlenmeli
1. URL ye gider
2. "hesabım" tıklanır
3."kullanıcı adı" ve  "password" girilir
4. girişyap tıklanır
5. Anasayfada "hesabım" tıklanır
5. "Store Manager"  tıklanır
6. "ürün" menüsü tıklanır
7. "ürün ekle" butonu tıklanır
8. "Shipping" butonu tıklanır
9. Weight (kg) kutusuna kilo belirlendiğin test eder
10. Dimensions Length değerlerinin belirlenebilirliğini test eder

     */

    @Test(priority = 2)
    public void US09_TC01() {
        waitFor(10);
        page.Weight.click();
        page.Weight.clear();
        page.Weight.sendKeys("10");
        bekle();
        bekle();
        page.Length.click();
        page.Length.clear();
        page.Length.sendKeys("20");
        bekle();
        bekle();
        page.height.click();
        page.height.clear();
        page.height.sendKeys("30");
    }
/*
    US09_TC02 Hacim ve ne kadar surede teslimat yapilacagi belirlenmeli
1. URL ye gider
2. "hesabım" tıklanır
3."kullanıcı adı" ve  "password" girilir
4. girişyap tıklanır
5. Anasayfada "hesabım" tıklanır
6. "Store Manager"  tıklanır
7. "ürün" menüsü tıklanır
8. "ürün ekle" butonu tıklanır
9. "Shipping" butonu tıklanır
10. Hacim seçeneğinin varlığını test eder
11. Processing Time seçeneğinden süre belirlenmeli
     */

    @Test(priority = 3)
    public void US09_TC02() {
        Select select =new Select(page.processingTime);
        List<WebElement> processingTime= select.getOptions();
        for (WebElement each:processingTime) {
            each.click();
            System.out.println(each.getText());
        }

    }
}
