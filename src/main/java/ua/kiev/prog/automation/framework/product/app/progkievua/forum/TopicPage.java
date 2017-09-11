package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

import java.util.List;

public class TopicPage extends PageObject
{
    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//li[@class='last']/a/span[text()='QA Automation']");
    }

    private By _authors = By.xpath("//div[contains(@class,'windowbg')]//div[@class='poster']/h4/a");
    private By _users   = By.xpath("//li[@id='button_mlist']/a");

    public void printAllAuthors ()
    {
        List<WebElement> list = this.component().session().driver().findElements(_authors);
        for (WebElement element: list) {
            System.out.println(element.getText());
        }
    }

    public UserListPage openUsers ()
    {
        this.component().session().driver().findElement(_users).click();
        return new UserListPage();
    }
}
