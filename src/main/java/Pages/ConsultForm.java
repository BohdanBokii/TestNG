package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConsultForm {
    @FindBy(id = "input-name-consultation")
    WebElement name;

    @FindBy(id = "input-tel-consultation")
    WebElement tel;

    @FindBy(id = "input-email-consultation")
    WebElement email;

    @FindBy(xpath = "//button[@class =\"socials-input-triggers_btn btn-icon-only\"]")
    List<WebElement> messenger;

    @FindBy(xpath = "//button[@id = \"listbox-btn-input-course-consultation\"]")
    WebElement courses;

    @FindBy(xpath = "//li[@class=\"listbox_option\"]")
    List<WebElement> listOfCourses;

    @FindBy(id = "input-comment-consultation")
    WebElement comment;

    public ConsultForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMessenger(String messengers) {
        for (WebElement l : messenger) {
            if (l.getAttribute("data-name").equals(messengers)) {
                l.click();
                break;
            }
        }
    }
    public void selectCourse(String s) {
        courses.click();
        for (WebElement l:listOfCourses) {
            if(l.getText().equals(s)){
                l.click();
                break;
            }
        }
    }
    public void create(String name, String email, String tel, String messenger, String courses, String text) {
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.tel.sendKeys(tel);
        clickMessenger(messenger);
        selectCourse(courses);
        comment.sendKeys(text);
    }
}


