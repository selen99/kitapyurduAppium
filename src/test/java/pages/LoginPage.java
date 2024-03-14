package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public By notificationALERT = By.xpath("//android.widget.TextView[@text=\"Bildirimleri açmak ister misiniz?\"]");
    public By notificationDenyBTN = By.id("com.mobisoft.kitapyurdu:id/btnLaterOn");
    public By myAccountBTN = By.id("com.mobisoft.kitapyurdu:id/btn_ic_header_account");
    public By emailINPUT = By.xpath("(//android.widget.EditText[@resource-id=\"com.mobisoft.kitapyurdu:id/inputEditText\"])[1]");
    public By passwordINPUT = By.xpath("(//android.widget.EditText[@resource-id=\"com.mobisoft.kitapyurdu:id/inputEditText\"])[2]");
    public By girisYapBTN = By.id("com.mobisoft.kitapyurdu:id/btnLogin");
    public By warningMessageALERT = By.id("com.mobisoft.kitapyurdu:id/textViewDesc1");
    public By tamamBTN = By.id("com.mobisoft.kitapyurdu:id/confirmButton");
    public By controlTXT = By.id("com.mobisoft.kitapyurdu:id/txt_username");
    public By emailDeleteBTN = By.xpath("(//android.widget.ImageView[@content-desc=\"null Temizleme Butonu\"])[1]");
    
    @Override
    public void click(By locator) {
        super.click(locator);
    }

    @Override
    public void doubleClick(By locator, int times) throws InterruptedException {
        super.doubleClick(locator, times);
    }

    @Override
    public boolean checkElement(By locator, int timeToWait) {
        return super.checkElement(locator, timeToWait);
    }

    @Override
    public void control(By locator, String expectedValue) {
        super.control(locator, expectedValue);
    }

    @Override
    public void displayLog(String text) {
        super.displayLog(text);
    }
}
