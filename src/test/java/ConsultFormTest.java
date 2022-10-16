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


import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class ConsultFormTest extends BaseClass {
    WebDriver driver;
    ConsultForm form;
    HillelMainPage hillelMainPage;

    String NAME;



    @Before
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

    @After
    public void Thread() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @Test()
    public void OpenSite() {
        driver.get("https://dnipro.ithillel.ua/");
        Assert.assertEquals(driver.getTitle(), "Комп'ютерна школа Hillel у Дніпрі: Курси IT-технологій");
    }

    @Test
    public void CheckAndClickConsultButton() {
        if (HillelMainPage.element.isEnabled()) {
            hillelMainPage.clickConsultButton();
        } else {
            System.out.println(("Element doesn't exist"));
        }
    }

    @Test
    public void testForm() {
        hillelMainPage.clickConsultButton();
        ResourceBundle bundle = ResourceBundle.getBundle(NAME);
        form.create(bundle.getString("name"), bundle.getString("email"), bundle.getString("tel"),
                bundle.getString("messenger"), bundle.getString("courses"), "Hello");
    }
}
