package tests.deneme;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.Assert.*;

public class DenemeTest {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
    }
}