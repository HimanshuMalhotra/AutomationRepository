package test.Pages;

import Utilities.GenericUtils;
import Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by malhoh on 06/02/2018.
 */

    public class LandingPage {

        WebDriver driver;
        SeleniumUtils seleniumUtils;
        GenericUtils genericUtils;



        public LandingPage(WebDriver driver) {
            this.driver = driver;
            seleniumUtils = new SeleniumUtils(driver);
            genericUtils = new GenericUtils();
        }


        //Web Element Locators

        By signinButton =By.className("login");

        By emailTextBox = By.name("email");

        By passwordTextBox = By.name("passwd");

        By loginButton = By.id("SubmitLogin");

    //No other locators are working except for this xpath
        By tshirtMenuButton = By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");//By.cssSelector("a[title='T-shirts']");//By.cssSelector(".sfHoverForce>a")


        By signOutButton = By.className("logout");


        By orderCompleteConfirmationLabel=By.className("dark")
         ;








    public void clickOnSignInButton() {
        seleniumUtils.clickOnElement(signinButton);
        }


        // This method is to set UserName in text box
        public void setEmail(String strUser) {
            seleniumUtils.clickOnElement(emailTextBox);
            seleniumUtils.sendValue(emailTextBox, strUser);
        }

        // This method is to set Password in the password text box
        public void setPassword(String strPassword) {
            seleniumUtils.clickOnElement(passwordTextBox);
        seleniumUtils.sendValue(passwordTextBox, strPassword);
        }

        public void clickOnLoginButton() {
            seleniumUtils.clickOnElement(loginButton);
        }

        public void clickOnTshirtMenuButton() {
            seleniumUtils.clickOnElement(tshirtMenuButton);
        }













    public boolean validateSignIn() {
            return seleniumUtils.isElementVisible(signOutButton);
        }

    public boolean validateConfirmationPage() {
        return seleniumUtils.isElementVisible(orderCompleteConfirmationLabel);
    }

    public boolean validateOrderHistory() {
        return seleniumUtils.isElementVisible(signOutButton);
    }



    public void login() {
        clickOnSignInButton();
        seleniumUtils.sendValue(emailTextBox, genericUtils.getStringPropValue("emailID"));
        seleniumUtils.sendValue(passwordTextBox, genericUtils.getStringPropValue("password"));
        clickOnLoginButton();
    }




}




