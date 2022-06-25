package tests;

import org.testng.annotations.Test;
import pages.US_19_22_Page;

public class US22 {
    US_19_22_Page page= new US_19_22_Page();

    @Test
    public void US22_TC01() throws InterruptedException {
        Login.login();
        Thread.sleep(3000);
        page.indirimliTumunuGor.click();
    }
}
