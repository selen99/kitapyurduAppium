package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.driver.Driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BasePage extends Driver {
    public static Logger logger = LoggerFactory.getLogger(BasePage.class);
    HashMap<String, String > keyMap = new HashMap<String, String>();

    //Checks if the element located by the given locator is visible within 30 seconds.
    public boolean checkElement(By locator, int timeToWait){
        try {
            WebDriverWait isElementVisible = new WebDriverWait(appiumDriver, timeToWait);
            isElementVisible.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element is found! Element is: " + locator);
            return true;
        }catch (Exception e){
            logger.info("Waited " + timeToWait + " seconds to find the element but could not find it! The element is: " + locator);
            return false;
        }
    }
    //Checks if the text of the element located by the provided locator matches the given value.
    public void control(By locator, String expectedValue){
        checkElement(locator, 20);
        String actualValue = appiumDriver.findElement(locator).getText();
        Assert.assertEquals("Text value does not match with the expected value", expectedValue, actualValue);
        logger.info(expectedValue + " is visible.");
    }
    //Clicks on the element located by the given locator after ensuring its visibility.
    public void click(By locator){
        checkElement(locator, 20);
        appiumDriver.findElement(locator).click();
        logger.info("Clicked to " + locator);
    }
    //Double clicks on the element located by the given locator after ensuring its visibility.
    public void doubleClick(By locator, int times) throws InterruptedException {
        checkElement(locator, 20);
        for(int i=0; i<times; i++){
            appiumDriver.findElement(locator).click();
            wait(2);
        }
        logger.info("Bulunan Elemente " + times + " Kere Tiklandi" );
    }
    //Writes the given value to the element located by the provided locator after ensuring its visibility.
    public void writeToElement(By locator, String value){
        checkElement(locator, 20);
        appiumDriver.findElement(locator).sendKeys(value);
        logger.info(value + " is written to " + locator);
    }
    //Scrolls down the page until the element located by the provided locator becomes visible.
    public void scrollUntilElementVisible(By locator, double scrollRate){
        try {
            while (appiumDriver.findElements(locator).size() == 0) {
                Dimension size = appiumDriver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * scrollRate);
                new TouchAction<>(appiumDriver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release().perform();
                logger.info("Scrolled down until " + locator);
            }
        }catch (Exception e){
            logger.info(e.getMessage() + locator + " could not scrolled down because element could not find!!!!");
        }
    }
    public void scrollUpUntilElementVisible(By locator, double scrollRate){
        try {
            while (appiumDriver.findElements(locator).size() == 0) {
                Dimension size = appiumDriver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * scrollRate);
                int endY = (int) (size.height * 0.8);
                new TouchAction<>(appiumDriver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(startX, endY))
                        .release().perform();
                logger.info("Scrolled up until " + locator);
            }
        }catch (Exception e){
            logger.info(e.getMessage() + locator + " could not scrolled down because element could not find!!!!");
        }
    }
    //Save a key-value pair in the map.
    public void saveValue(String key, String value){
        keyMap.put(key, value);
    }
    //Retrieves the value associated with the specified key from the map.
    public String getValue(String key){
        return keyMap.get(key).toString();
    }
    //Pauses the execution for the given number of seconds.
    public void wait(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }
    //Clicks on two random brands from the list of elements located by the provided locator, saves their product number as specified keys, calculates the total product number.
    public void clickTwoRandomBrandsAndSveValues(By locator, String key1, String key2, String key3){
        checkElement(locator, 20);
        List<MobileElement> elements = appiumDriver.findElements(locator);
        Random rand = new Random();
        int firstIndex = rand.nextInt(Math.min(elements.size(), 13));
        int secondIndex;
        do {
            secondIndex = rand.nextInt(Math.min(elements.size(), 13));
        }while (secondIndex == firstIndex);
        String firstIndexNumber = elements.get(firstIndex).getText();
        String secondIndexNumber = elements.get(secondIndex).getText();
        logger.info("First brand product number " + firstIndexNumber + " saved as " + key1);
        logger.info("Second brand product number " + secondIndexNumber + " saved as " + key2);
        int totalProductNumber = Integer.valueOf(firstIndexNumber) + Integer.valueOf(secondIndexNumber);
        saveValue(key3, String.valueOf(totalProductNumber));
        logger.info("Total product number is: " + totalProductNumber);
        elements.get(firstIndex).click();
        elements.get(secondIndex).click();
        logger.info("Clicked two random brands.");
    }
    //Extracts and returns the numerical part from a given text.
    public String extractNumber(String text){
        int startingIndex = text.indexOf("(");
        int finalIndex = text.indexOf(")");
        String number = text.substring(startingIndex + 1, finalIndex).replaceAll("[^0-9]", "");
        return number;
    }
    //Compares the text of an element identified by the locator with the value associated with the key.
    public void checkerMethod(By locator, String key, boolean extractNumber){
        checkElement(locator, 20);
        String checkedTxt = appiumDriver.findElement(locator).getText();
        if(extractNumber){
            checkedTxt = extractNumber(checkedTxt);
        }
        Assert.assertEquals(getValue(key), checkedTxt);
        if (extractNumber){
            logger.info("Total of two random values " + getValue(key) + " and the value inside of search nox " + checkedTxt + " are compared.");
        }else{
            logger.info("Two values " + getValue(key) + " and " + checkedTxt + " are compared.");
        }
    }
    //Saves the text of an element identified by the locator with the specified key.
    public void saverMethod(By locator, String key){
        checkElement(locator, 20);
        String savedTxt = appiumDriver.findElement(locator).getText();
        saveValue(key, savedTxt);
        logger.info("Value " + savedTxt + " inside of " + locator + " is saved.");
    }
    public void displayLog(String text){
        logger.info(text);
    }
    public String getText(By locator){
        return appiumDriver.findElement(locator).getText();
    }
}
