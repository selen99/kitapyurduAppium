package pages;

import org.openqa.selenium.By;

public class SearchPage extends BasePage{
    public By araCategoriesBTN = By.id("com.mobisoft.kitapyurdu:id/navigation_search");
    public By searchAREA = By.id("com.mobisoft.kitapyurdu:id/searchEditText");
    public By emptyArea = By.id("com.mobisoft.kitapyurdu:id/searchListView");
    public By resetBTN = By.id("com.mobisoft.kitapyurdu:id/btn_clear");
    public By book = By.xpath("//android.widget.TextView[@bounds=\"[34,514][1046,571]\"]");
    public By filterBTN = By.id("com.mobisoft.kitapyurdu:id/filterButton");
    public By yazarBTN = By.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewFilterName\" and @text=\"Yazar\"]");
    public By secimiUygulaBTN = By.id("com.mobisoft.kitapyurdu:id/btnShowProducts");
    public By urunleriGosterBTN = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Ürünleri Göster\"]");
    public By siralaBTN = By.id("com.mobisoft.kitapyurdu:id/sortButton");
    public By cokSatanlarBTN = By.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewSortType\" and @text=\"Çok Satanlar\"]");
    public By firstBook = By.xpath("(//android.widget.ImageView[@content-desc=\"Ürün görseli\"])[1]");
    public By addToCartBTN = By.id("com.mobisoft.kitapyurdu:id/addToCartNormalView");
    public By myCartBTN = By.xpath("(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/icon\"])[5]");
    public By HPFTBook = By.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/textViewProductName\" and @text=\"Harry Potter ve Felsefe Taşı\"]");
    public By silBTN = By.xpath("(//android.widget.TextView[@text=\"Sil\"])[1]");
    public By secondSilBTN = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Sil\"]");
    @Override
    public void click(By locator) {
        super.click(locator);
    }

    @Override
    public void writeToElement(By locator, String value) {
        super.writeToElement(locator, value);
    }

    @Override
    public boolean checkElement(By locator, int timeToWait) {
        return super.checkElement(locator, timeToWait);
    }

    @Override
    public void displayLog(String text) {
        super.displayLog(text);
    }
}
