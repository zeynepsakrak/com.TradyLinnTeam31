package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.US_08_09_10_Page;
import utilities.Driver;

import static tests.ReusableMethods.urun_ekle_menusune_gidilir;

public class US10 {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void testName(){
        urun_ekle_menusune_gidilir();
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
}
