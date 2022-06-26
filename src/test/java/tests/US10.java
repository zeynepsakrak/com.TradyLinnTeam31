package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.US_08_09_10_Page;
import utilities.Driver;

import java.util.List;

import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.urun_ekle_menusune_gidilir;

public class US10 {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void testName(){
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Attributes.click();
        bekle();

    }
    /*
    US10_TC01 Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtilmeli
1. URL ye gider
2. "hesabım" tıklanır
3."kullanıcı adı" ve  "password" girilir
4. girişyap tıklanır
5. Anasayfada "hesabım" tıklanır
5. "Store Manager"  tıklanır
6. "ürün" menüsü tıklanır
7. "ürün ekle" butonu tıklanır
8. "Attributes" butonu tıklanır
9. color un karşısındaki"Toogle Block" ok işareti tıklanır
10. "color" çubuğuna gelinir
11.bütün renk seçenekleri eklenir
     */

    @Test(priority = 2)
    public void US10_TC01() {
        ReusableMethods.waitFor(3);
        page.colorOk.click();
        ReusableMethods.waitFor(3);
        Select select2 =new Select(page.colorSelectAll);
        List<WebElement> colors= select2.getOptions();
        for (WebElement each:colors) {
            each.click();
            System.out.println(each.getText());
        }
    }
    /*
    US10_TC02 Size secenegi; small, medium, large, extra large olmali
1. URL ye gider
2. "hesabım" tıklanır
3."kullanıcı adı" ve  "password" girilir
4. girişyap tıklanır
5. Anasayfada "hesabım" tıklanır
5. "Store Manager"  tıklanır
6. "ürün" menüsü tıklanır
7. "ürün ekle" butonu tıklanır
8. size karşısındaki "Attributes" butonu tıklanır
9. "Toogle Block" ok işareti tıklanır
10. "size" çubuğuna gelinir
11. small, medium, large, extra large seçenekleri eklenir
     */
    @Test(priority = 3)
    public void US10_TC02() {
        ReusableMethods.waitFor(3);
        page.sizeOk.click();
        Select select3 =new Select(page.colorSelectAll);
        List<WebElement> size= select3.getOptions();
        for (WebElement each:size) {
            each.click();
            System.out.println(each.getText());
        }
    }
}
