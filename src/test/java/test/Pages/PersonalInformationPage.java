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

    public class PersonalInformationPage {

        WebDriver driver;
        SeleniumUtils seleniumUtils;
        GenericUtils genericUtils;

        public PersonalInformationPage(WebDriver driver) {
            this.driver = driver;
            seleniumUtils = new SeleniumUtils(driver);
            genericUtils = new GenericUtils();
        }

    By personalInformationButton=By.xpath(".//*[@title='Information']")   ;

    By firstNameTextbox =By.id("firstname");

    By lastNameTextbox =By.id("lastname");

    By currentPasswordTextbox=By.id("old_passwd");

    By saveInformationButton=By.name("submitIdentity")  ;

    @FindBy(how=How.XPATH, using=".//*[@id='center_column']/div/p") WebElement successMessageForDetailsUpdate1;

    By successMessageForDetailsUpdate=By.cssSelector(".alert.alert-success");

    public void clickOnPersonalInformationButton(){
        seleniumUtils.clickOnElement(personalInformationButton);
    }

    public void enterAccountDetails(){
        clickOnPersonalInformationButton();
        seleniumUtils.sendValue(firstNameTextbox, genericUtils.getStringPropValue("firtName_append"));
        seleniumUtils.sendValue(currentPasswordTextbox, genericUtils.getStringPropValue("password"));
        clickSaveInformationButton();
    }

    public void getSuccessMessageForUpdatingDetails(){
        getSuccessMessage();

    }

    public void getSuccessMessage() {

        String message = successMessageForDetailsUpdate1.getText();
        System.out.println(message);
    }

    public void setFirstName(String strFirstName){
        seleniumUtils.sendValue(firstNameTextbox,strFirstName);
    }

    public void setLastName(String strLastName){
        seleniumUtils.sendValue(lastNameTextbox,strLastName);
    }

    public void setCurrentPassword(String strPassword){
        seleniumUtils.sendValue(currentPasswordTextbox,strPassword);
    }

    public void clickSaveInformationButton(){
        seleniumUtils.clickOnElement(saveInformationButton);
    }

    public boolean validateAccountDetailsPage() {
        return seleniumUtils.isElementVisible(successMessageForDetailsUpdate);
    }

    public boolean validateSuccessMessage() {
        return seleniumUtils.isElementVisible(successMessageForDetailsUpdate);
    }
}




