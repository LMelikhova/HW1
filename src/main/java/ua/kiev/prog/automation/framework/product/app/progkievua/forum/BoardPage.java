package ua.kiev.prog.automation.framework.product.app.progkievua.forum;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.PageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

public class BoardPage extends PageObject
{
    @Override
    protected Class<? extends Component> componentClass()
    {
        return Forum.class;
    }

    @Override
    protected By readyLocator()
    {
        return By.xpath("//table[@class='table_grid']");
    }

    private By _firstTopic = By.xpath("//table[@class='table_grid']/tbody/tr[1]/td[contains(@class,'subject')]//span/a");

    public TopicPage openTopic ()
    {
        this.component().session().driver().findElement(_firstTopic).click();
        return new TopicPage();
    }
}
