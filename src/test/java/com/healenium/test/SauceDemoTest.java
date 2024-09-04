package com.healenium.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.healenium.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.sql.SQLOutput;
import java.time.Duration;

public class SauceDemoTest extends Base {

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
//        driver.get("file:///Users/kishore/Desktop/Github/healenium-web-withoutdocker/src/test/page.html");
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test(priority = 1)
    public void loginTest() {
        test = extent.createTest("Checking the login functionality").assignAuthor("sai teja");
        String username = jsonObject.get("user").getAsString();
        String password = jsonObject.get("password").getAsString();
        loginPage.enterUsernameAndPassword(username,password);
        loginPage.clickOnLoginButton();
        String headerText = jsonObject.get("headerText").getAsString();
        assertEquals(loginPage.getHeaderText() ,headerText);
        loginPage.logout();

    }

    @Test(priority = 2)
    public void addToCartTest() {
        test = extent.createTest("Checking the add to cart functionality").assignAuthor("sai teja");
        String username = jsonObject.get("user").getAsString();
        String password = jsonObject.get("password").getAsString();
        loginPage.enterUsernameAndPassword(username,password);
        loginPage.clickOnLoginButton();
        String headerText = jsonObject.get("headerText").getAsString();
        assertEquals(loginPage.getHeaderText() ,headerText);
        addToCartPage.clickOnAddToCart();
        addToCartPage.clickOnCheckout();
        String firstname = jsonObject.get("firstname").getAsString();
        String lastname = jsonObject.get("lastname").getAsString();
        String pinCOde = jsonObject.get("pinCode").getAsString();
        addToCartPage.enterUserDetails(firstname,lastname,pinCOde);
        addToCartPage.clickOnFinish();
        assertTrue(addToCartPage.isBackHomeBtnVisible());
        addToCartPage.clickOnBackHome();
        loginPage.logout();
    }

    @Test(priority = 3)
    public void sideBarValidationTest() throws InterruptedException {
        test = extent.createTest("Side Bar Validation").assignAuthor("sai teja");
        String username = jsonObject.get("user").getAsString();
        String password = jsonObject.get("password").getAsString();
        loginPage.enterUsernameAndPassword(username,password);
        loginPage.clickOnLoginButton();
        String headerText = jsonObject.get("headerText").getAsString();
        assertEquals(loginPage.getHeaderText() ,headerText);
        sideBarValidation.clickOnSideBarBtn();
        JsonArray sideBarElements = jsonObject.get("sideBarEle").getAsJsonArray();
        for(JsonElement element : sideBarElements) {
            Thread.sleep(3000);
            assertTrue(sideBarValidation.sideBarValidation(element.getAsString()));
        }
        sideBarValidation.clickOnCloseBtn();
        loginPage.logout();
    }

    @Test(priority = 4)
    public void sortingTest() {
        test = extent.createTest("Checking the login functionality").assignAuthor("sai teja");
        String username = jsonObject.get("user").getAsString();
        String password = jsonObject.get("password").getAsString();
        loginPage.enterUsernameAndPassword(username,password);
        loginPage.clickOnLoginButton();
        String headerText = jsonObject.get("headerText").getAsString();
        assertEquals(loginPage.getHeaderText() ,headerText);
        String filterText = jsonObject.get("filterText").getAsString();
        homePage.filterProducts(filterText);
        String productText = jsonObject.get("productText").getAsString();
        assertEquals(homePage.getProductText(),productText);
        loginPage.logout();
    }

//    @Test(priority = 4)
//    public void demoIframe() {
//        test = extent.createTest("Checking the login functionality").assignAuthor("karthik");
//        //Store the web element
//        WebElement iframe = driver.findElement(By.id("iframe-1"));
//
////Switch to the frame
//        driver.switchTo().frame(iframe);
//
////Now we can click the button
//        driver.findElement(By.xpath("//a[text()='Docs']")).click();
//        // Return to the top level
//        driver.switchTo().defaultContent();
//    }
//    @Test(priority = 5)
//    public void demoIframehtml() {
//        test = extent.createTest("Checking the login functionality").assignAuthor("karthik");
//        //Store the web element
//        WebElement iframe = driver.findElement(By.id("buttonIframe"));
//
////Switch to the frame
//        driver.switchTo().frame(iframe);
//
////Now we can click the button
//        driver.findElement(By.xpath("//button[text()='Button 1']")).click();
//        // Return to the top level
//        driver.switchTo().defaultContent();
//    }
}
