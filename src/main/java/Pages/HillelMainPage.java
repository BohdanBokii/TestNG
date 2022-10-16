package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HillelMainPage {

    @FindBy(id = "btn-consultation-hero")
    public static WebElement element;

    public HillelMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void clickConsultButton() {
        element.click();
    }
}
