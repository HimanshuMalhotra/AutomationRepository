package test.Pages;

import Utilities.GenericUtils;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaurmnd on 07/02/2018.
 */
public class OrderPage {

    WebDriver driver;
    SeleniumUtils seleniumUtils;
    GenericUtils genericUtils;

    String orderId2;
    String orderId1;
    boolean id;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        seleniumUtils = new SeleniumUtils(driver);
        genericUtils = new GenericUtils();
    }

    //No other locators are working except for this xpath
    By productButton=By.xpath("//div[@class='product-container']");//By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");//By.xpath("//a[@class='product_img_link']/img"); //By.xpath(".//img[@class='replace-2x img-responsive']")
    ;

    By addToCartButton=By.name("Submit")
            ;

    By proceedToCheckoutButton=By.xpath(".//*[@title='Proceed to checkout']")
            ;

    //No other locators are working except for this xpath
    By proceedToCheckoutSummaryPage= By.xpath(".//*[@id='center_column']/p[2]/a[1]/span");//By.xpath(".//*[@title='Proceed to checkout']")
    ;

    By proceedToCheckoutAddressPage=By.name("processAddress")
            ;

    By proceedToCheckoutShippingPage= By.name("processCarrier")
            ;

    By iAgreeTermsCheckbox=By.id( "cgv");

    By payByBankWire=By.className( "bankwire")
            ;

    By confirmOrderButton= By.xpath(".//*[@id='cart_navigation']/button")
            ;

    By customerAccountButton= By.className("account")
            ;

    By orderHistoryAndDetailsButton=By.xpath( ".//*[@title='Orders']")
            ;

    @FindBy(how= How.CLASS_NAME, using="box")
    WebElement boxContent;

    By proceedToCheckoutQuickView= By.xpath("//i[@class='icon-chevron-right right']");

    @FindBy(how=How.CSS, using=".color-myaccount")
    WebElement orderIdInOrderHistory;


    public void clickOnProductButton() {
        seleniumUtils.clickOnElement(productButton);
        //seleniumUtils.clickOnElement(By.className("quick-view"));
        seleniumUtils.clickOnElement(By.xpath("//span[text()='Add to cart']"));
    }

    public void clickOnAddToCartButton() {
        seleniumUtils.clickOnElement(addToCartButton);
    }

    public void clickOnProceedToCheckoutButton() {
        seleniumUtils.clickOnElement(proceedToCheckoutButton);
    }

    public void clickOnProceedToCheckoutSummaryPage() {
        //seleniumUtils.clickOnElement(proceedToCheckoutQuickView);
        seleniumUtils.clickOnElement(proceedToCheckoutSummaryPage);
    }

    public void clickOnProceedToCheckoutAddressPage() {
        seleniumUtils.clickOnElement(proceedToCheckoutAddressPage);
    }

    public void clickOnIAgreeTermsCheckbox() {
        seleniumUtils.click(iAgreeTermsCheckbox);
    }

    public void clickOnProceedToCheckoutShippingPage() {
        seleniumUtils.clickOnElement(proceedToCheckoutShippingPage);
    }

    public void clickOnPayByBankWire() {
        seleniumUtils.clickOnElement(payByBankWire);
    }

    public void clickOnConfirmOrderButton() {
        seleniumUtils.clickOnElement(confirmOrderButton);
    }

    public void clickOnCustomerAccountButton() {
        seleniumUtils.clickOnElement(customerAccountButton);
    }

    public void clickOnOrderHistoryAndDetailsButton() {
        seleniumUtils.clickOnElement(orderHistoryAndDetailsButton);
    }

    public void getBoxContent() {

        String text = boxContent.getText();
        Pattern p = Pattern.compile("\\b[A-Z]{4,}\\b");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String word = m.group();
            orderId1=word;
            System.out.println(word);
        }
    }

    public boolean matchOrderId(){
        return orderId1.equalsIgnoreCase(orderId2);
    }

    public void getOrderIdFromOrderHistory() {
        clickOnCustomerAccountButton();
        clickOnOrderHistoryAndDetailsButton();
        String orderId = orderIdInOrderHistory.getText();
        orderId2=orderId;
        System.out.println(orderId);
    }

    public void orderTShirt() {
        clickOnProductButton();
        clickOnProceedToCheckoutButton();
        clickOnProceedToCheckoutSummaryPage();
        clickOnProceedToCheckoutAddressPage();
        clickOnIAgreeTermsCheckbox();
        clickOnProceedToCheckoutShippingPage();
        clickOnPayByBankWire();
        clickOnConfirmOrderButton();
        getBoxContent();
    }
}
