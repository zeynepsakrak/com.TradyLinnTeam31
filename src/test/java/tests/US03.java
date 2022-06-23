package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US03 {

    @Test
    public void US03_TC01(){
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
    }
}
