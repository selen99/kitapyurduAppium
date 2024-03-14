package pageSteps;

import com.thoughtworks.gauge.Step;
import pages.SearchPage;

public class SearchStep {
    SearchPage searchPage = new SearchPage();

    @Step("Click ara button")
    public void clickArabButton() {
        searchPage.click(searchPage.araCategoriesBTN);
    }

    @Step("Type meaningless words <MeaninglessBookName>")
    public void typeMeaninglessWords(String MeaninglessBookName) {
        searchPage.writeToElement(searchPage.searchAREA, MeaninglessBookName);
    }

    @Step("Check that no result come up")
    public void controlStep() {
        if (searchPage.checkElement(searchPage.emptyArea, 10)) {
            searchPage.displayLog("There are no results to show!!");
        }
    }

    @Step("Reset search area")
    public void deleteOldInput() {
        searchPage.click(searchPage.resetBTN);
    }

    @Step("Type book name <bookName>")
    public void writeBookName(String bookName) {
        searchPage.writeToElement(searchPage.searchAREA, bookName);
    }

    @Step("Click the book")
    public void clickTheBook() {
        searchPage.click(searchPage.book);
    }

    @Step("Click to filter")
    public void clickToFilter() {
        searchPage.click(searchPage.filterBTN);
    }

    @Step("Click to yazar")
    public void clickToYazar() {
        searchPage.click(searchPage.yazarBTN);
    }

    @Step("Click to J.K Rowling checkbox")
    public void clickToRowling() {
        searchPage.click(searchPage.yazarBTN);
    }

    @Step("Click to secimi uygula button")
    public void clickToSecimiUygula() {
        searchPage.click(searchPage.secimiUygulaBTN);
    }

    @Step("Click to urunleri goster button")
    public void clickUrunleriGoster() {
        searchPage.click(searchPage.urunleriGosterBTN);
    }

    @Step("Click to sirala button")
    public void clickToSortButton() {
        searchPage.click(searchPage.siralaBTN);
    }

    @Step("Click to cok satanlar")
    public void clickToSatanlar() {
        searchPage.click(searchPage.cokSatanlarBTN);
    }

    @Step("Click to first book")
    public void clickFirstBook() {
        searchPage.click(searchPage.firstBook);
    }

    @Step("Add book to Cart")
    public void addToCart() {
        searchPage.click(searchPage.addToCartBTN);
    }

    @Step("Click to cart button")
    public void clickToMyCart() {
        searchPage.click(searchPage.myCartBTN);
    }

    @Step("Check if the book has been added to the cart")
    public void sepeteEklendiMi() {
        searchPage.control(searchPage.HPFTBook, "Harry Potter ve Felsefe Taşı");
    }

    @Step("Delete book from cart")
    public void deleteItemFromCart() {
        searchPage.click(searchPage.silBTN);
        searchPage.click(searchPage.secondSilBTN);
    }

    @Step("Click to search button")
    public void clickSearchButton() {
        searchPage.click(searchPage.searchAREA);
    }
}
