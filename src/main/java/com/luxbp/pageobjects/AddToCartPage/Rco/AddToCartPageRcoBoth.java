package com.luxbp.pageobjects.AddToCartPage.Rco;

import com.aventstack.extentreports.ExtentTest;
import com.luxbp.actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.luxbp.base.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPageRcoBoth extends BaseClass {

    @FindBy(xpath = "//*[@class='ss-gizmo ss-delete text-dark text-2h6 opacity-40 hover:opacity-100 slow-color-change leading-none icon-lg']")
    WebElement closeVerifyMessage;
    @FindBy(xpath = "//span[text()='Products']")  //Click on Products dropdown
    WebElement products;

    @FindBy(xpath = "//*[@data-id='icon-rco']")            //Click R+CO brand
    WebElement rCO;

    @FindBy(xpath = "(//a[@href='/brands/r-and-co'])[1]")       //Back to R+Co
    WebElement back;

    @FindBy(xpath = "(//a[@data-testid='productLink'])[6]")  //Click on item name of selected brand product
    WebElement productOne;

    @FindBy(xpath = "//*[contains(@class,'product__name')]")
    WebElement verifyProductName;

    @FindBy(xpath = "//*[@class='mb-6.5 lg:mb-0']")  //Click on All filter
    WebElement clickElse;

    @FindBy(xpath = "//*[@class='ss-gizmo absolute mr-6 -mt-1.5 right-0 top-50% leading-none ss-right']")  //Click on Buy button
    WebElement buyProductOne;

    @FindBy(xpath = "(//*[@class='ss-gizmo absolute mr-6 -mt-1.5 right-0 top-50% leading-none ss-right'])[1]")    //Click buy with Points
    WebElement buyWithPoints;

    @FindBy(xpath = "//a[@href='/brands/r-and-co/not-for-resale']")        //Click Redeem
    WebElement redeemYourPoints;

    @FindBy(xpath = "(//a[@data-testid='productLink'])[6]")
    WebElement prodPoint;
    @FindBy(xpath = "(//*[@type=\'button\'])[4]")
    WebElement prodString;

    ExtentTest addToCartRcoBothReport = extent.createTest("R+CO both item test functionality");

    public AddToCartPageRcoBoth() {
        PageFactory.initElements(driver, this);
    }

    public void clickProductRcoDollar() throws InterruptedException {

        WebDriverWait waitAlter1 = new WebDriverWait(driver, 5);
        waitAlter1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
        Thread.sleep(5000);

        Action.click(driver, products);
        driver.findElement(By.cssSelector("a[href='/brands/r-and-co'][target='']")).click();

        WebDriverWait waitFilter = new WebDriverWait(driver, 5);
        waitFilter.until(ExpectedConditions.visibilityOf(clickElse));
        clickElse.click();
    }

    public void prodPoint() {
        WebDriverWait waitRedeemProd = new WebDriverWait(driver, 5);
        waitRedeemProd.until(ExpectedConditions.visibilityOf(prodPoint));
        prodPoint.click();
    }

    public void buyFirstProdBoth() {
        WebDriverWait waitBuyProductOne = new WebDriverWait(driver, 10);
        waitBuyProductOne.until(ExpectedConditions.visibilityOf(buyProductOne));
        Action.click(driver, buyProductOne);
        addToCartRcoBothReport.pass("Product added successfully");
/*        String buyBtnExpectedMesg = "OUT OF STOCK";
        String buyBtnActualMesg = prodString.getText();

       if (buyBtnActualMesg.equals(buyBtnExpectedMesg)) {
            System.out.println("Product is out of stock");
            addToCartRcoBothReport.fail("Product is out of stock");
            tearDown();
        } else {
            WebDriverWait waitBuyProductOne = new WebDriverWait(driver, 10);
            waitBuyProductOne.until(ExpectedConditions.visibilityOf(buyProductOne));
            Action.click(driver, buyProductOne);
            addToCartRcoBothReport.pass("Product added successfully");
        }*/
    }

    public void backToRedeem() throws InterruptedException {
        back.click();
        redeemYourPoints.click();
        Thread.sleep(8000);
        prodPoint.click();
        WebDriverWait waitBuyProductOne = new WebDriverWait(driver, 10);
        waitBuyProductOne.until(ExpectedConditions.visibilityOf(buyWithPoints));
        buyWithPoints.click();
        addToCartRcoBothReport.pass("Product added successfully");

      /*  String buyBtnExpectedMesg = "OUT OF STOCK";
        String buyBtnActualMesg = prodString.getText();

        Thread.sleep(5000);     //Needed to use thread as there are no elements changed to explicity wait
        if (buyBtnActualMesg.equals(buyBtnExpectedMesg)) {
            System.out.println("Product is out of stock");
            addToCartRcoBothReport.fail("Product is out of stock");
            tearDown();
        } else {
            prodPoint.click();

            WebDriverWait waitRedeemProd = new WebDriverWait(driver, 5);
            waitRedeemProd.until(ExpectedConditions.visibilityOf(buyWithPoints));

            buyWithPoints.click();
            addToCartRcoBothReport.pass("Product added successfully");
        }*/
    }


    public String getItemNameRcoBoth() {
/*        WebDriverWait waitItem = new WebDriverWait(driver, 5);
        waitItem.until(ExpectedConditions.visibilityOf(productOne));*/
        String message = productOne.getText();
        System.out.println("Product Name -> " + message);
        return message;
    }

    public String validateAddProductBoth() {
/*        WebDriverWait waitAlter = new WebDriverWait(driver, 5);
        waitAlter.until(ExpectedConditions.visibilityOf(closeVerifyMessage));*/
        String message = verifyProductName.getText();
        System.out.println("Expected item name -> " + message);
        return message;
    }
}

