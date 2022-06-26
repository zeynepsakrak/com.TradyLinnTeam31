package tests;

import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_08_09_10_Page;
import utilities.Driver;

import static tests.ReusableMethods.urun_ekle_menusune_gidilir;

public class US08 {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void testName() {
        urun_ekle_menusune_gidilir();
    }

    /*
        US08_TC01 Urun miktarı stock belirlenmeli
    1. URL e gider
    2. "giriş yap"  tıklanır
    3.  geçerli email adresi ve  şifre girilir
    4. "girişyap" tıklanır
    5. Anasayfada Hesabım tıklanır
    6. "Store Manager"  tıklanır
    7.  "ürün" menüsü tıklanır
    8.  "ürün ekle" butonu tıklanır
    9.  "Inventory" tıklanır
    10.  manage stock ikonu tıklanır
    11. ürün miktarı(stock quantity) belirlenir

         */

    @Test(priority = 2)
    public void US08_TC01() {
        actions.moveToElement(page.Inventory);
        page.Inventory.click();
        page.ManageStock.click();
        page.StockMiktar.clear();
        page.StockMiktar.sendKeys("10");
        Assert.assertTrue(page.StockMiktar.getText().contains("10"));
    }

    /*
    US08_TC02 Backorder izni verilebilmeli, gecici verilmeme optionu olmalı veya verilmeli ama müşteri bilgilendirilmeli
1. URL e gider
2. "giriş yap"  tıklanır
3.  geçerli email adresi ve  şifre girilir
4. "girişyap" tıklanır
5. Anasayfada Hesabım tıklanır
6. "Store Manager"  tıklanır
7.  "ürün" menüsü tıklanır
8. "ürün ekle" butonu tıklanır
9.  "Inventory" pagtıklanır
10.  manage stock ikonu tıklanır
11. AllowBlackorder "Allow" seçilebilirliğini test eder
12. "Allow, but notify custemar" seçeneğinin varlığını test eder
13. "Do Not Allow" seçeneğinin varlığını kontrol eder


     */

    @Test(priority = 3)
    public void US08_TC02() {

    }
}