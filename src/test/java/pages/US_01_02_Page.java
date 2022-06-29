package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_01_02_Page {

    public US_01_02_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement girisButonu;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement pasword;

    @FindBy(xpath = "//button[@name=\"login\"]")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//*[text()='Üye Ol']")
    public WebElement uyeOl;

    @FindBy(xpath = "//*[text()='Satıcı Ol']")
    public WebElement saticiOl;

    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabim;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordKutusu;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButonu;

    @FindBy(xpath = "(//*[text()='Siparişler'])[2]")
    public WebElement ordersButonu;

    @FindBy(xpath = "(//*[text()='İndirmeler'])[2]")
    public WebElement downloadsButonu;

    @FindBy(xpath = "(//*[text()='Adresler'])")
    public WebElement addressesButonu;

    @FindBy(xpath = "(//*[text()='Hesap Detayları'])")
    public WebElement accountDetailsButonu;

    @FindBy(xpath = "(//*[text()='Favorilerim'])[3]")
    public WebElement whislistButonu;

    @FindBy(xpath = "(//*[text()='Çıkış'])[2]")
    public WebElement logoutButonu;

    @FindBy(xpath ="//a[contains(text(),'Store Manager')]")
    public WebElement storeManagerDashboard;

    @FindBy(xpath = "(//*[text()='Siparişler'])[1]")
    public WebElement ordersButonuDashboard;

    @FindBy(xpath = "(//*[text()='İndirmeler'])[1]")
    public WebElement downloadsButonuDashboard;

    @FindBy(xpath = "(//*[text()='Adres'])")
    public WebElement addressesButonuDashboard;

    @FindBy(xpath = "(//*[text()='Hesap detayları'])")
    public WebElement accountDetailsButonuDashboard;

    @FindBy(xpath = "(//*[text()='Randevular'])[1]")
    public WebElement appoinmentsButonuDashboard;

    @FindBy(xpath = "(//*[text()='Favorilerim'])[2]")
    public WebElement whislistButonuDashboard;

    @FindBy(xpath = "(//*[text()='Destek Talepleri'])[1]")
    public WebElement supportTicketsButonuDashboard;

    @FindBy(xpath = "(//*[text()='Takip'])[1]")
    public WebElement followingsButonuDashboard;

    @FindBy(xpath = "(//*[text()='Çıkış'])[1]")
    public WebElement logoutButonuDashboard;

    @FindBy(xpath = "//*[text()=\"Çıkış Yap\"]")
    public WebElement cikisButonu;

}
