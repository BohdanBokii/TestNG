import Data.DataProv;
import DriverConfig.BROWSER;
import DriverConfig.BaseClass;
import DriverConfig.DriverFactory;
import Pages.ConsultForm;
import Pages.HillelMainPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class ConsultFormTest extends BaseClass {
    WebDriver driver;
    ConsultForm form;
    HillelMainPage hillelMainPage;


    @BeforeClass
    public void crate() {
        if (driver == null) {
            driver = DriverFactory.getDriver(BROWSER.CHROME);
        }
        if (form == null) {
            form = new ConsultForm(driver);
        }
        if (hillelMainPage == null) {
            hillelMainPage = new HillelMainPage(driver);
        }
    }

    @AfterClass
    public void after() {
        driver.close();
    }

    @Test(description = "Open main page hillel", priority = 0)
    public void openSite() {
        driver.get("https://dnipro.ithillel.ua/");
        Assert.assertEquals(driver.getTitle(), "Комп'ютерна школа Hillel у Дніпрі: Курси IT-технологій");
    }

    @Test(description = "Click on button", dependsOnMethods = "openSite", priority = 1)
    public void CheckAndClickConsultButton() {
        if (HillelMainPage.element.isEnabled()) {
            hillelMainPage.clickConsultButton();
        } else {
            System.out.println(("Element doesn't exist"));
        }
    }

    @Test(dataProvider = "dataFormConsult", dataProviderClass = DataProv.class, priority = 2)
    public void testForm(String name, String email, String tel, String messenger, String courses) throws InterruptedException {
        driver.get("https://dnipro.ithillel.ua/");
        hillelMainPage.clickConsultButton();
        form.create(name, email, tel, messenger, courses, "Hello");
        Thread.sleep(3000);
    }
}
