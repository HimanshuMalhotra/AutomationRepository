package test;

import Utilities.GenericUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import test.Pages.LandingPage;
import test.Pages.OrderPage;
import test.Pages.PersonalInformationPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Hooks{
    public static WebDriver driver;
    public GenericUtils genericUtils = new GenericUtils();
    
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
    	initializeBrowser();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
        driver.get(genericUtils.getStringPropValue("URL"));
        setPageObjects();
    }

    private void initializeBrowser() {
        String browser = genericUtils.getStringPropValue("browser");
        switch (browser){
            case "Firefox":
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                break;
        }
    }

    private void setPageObjects(){
        PageObjRefs.landingpage= PageFactory.initElements(driver, LandingPage.class);
        PageObjRefs.orderPage= PageFactory.initElements(driver, OrderPage.class);
        PageObjRefs.personalInformationPage= PageFactory.initElements(driver, PersonalInformationPage.class);
    }
     
    @After
    public void closeBrowser(Scenario scenario) {
       
    	if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
           }
           driver.close();
           driver.quit();        
    }
    
    
}