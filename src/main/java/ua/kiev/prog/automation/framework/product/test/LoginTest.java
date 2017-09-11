package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.LoginPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPage;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.TopicPage;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class LoginTest extends Test
{

    @Override
    public String name()
    {
        return "Login to forum test";
    }

    @Override
    public void beforeTest()
    {
        // Ð’Ñ‹Ð²Ð¾Ð´ Ð² ÐºÐ¾Ð½Ñ�Ð¾Ð»ÑŒ
        System.out.println("TEST: " + this.name() + " | PHASE: BEFORE RUN");
    }

    @Override
    public void test()
    {
        // Ð’Ñ‹Ð²Ð¾Ð´ Ð² ÐºÐ¾Ð½Ñ�Ð¾Ð»ÑŒ
        System.out.println("TEST: " + this.name() + " | PHASE: TEST");

        // ÐŸÐ¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð³Ð»Ð°Ð²Ð½ÑƒÑŽ Ñ�Ñ‚Ñ€Ð°Ð½Ð¸Ñ†Ñƒ
        MainPage mainPage   = Component.getSingleton(Forum.class).mainPage();
        // ÐŸÐµÑ€ÐµÑ…Ð¾Ð´Ð¸Ð¼ Ð½Ð° Ñ�Ñ‚Ñ€Ð°Ð½Ð¸Ñ†Ñƒ Ð»Ð¾Ð³Ð¸Ð½Ð°
        LoginPage loginPage = mainPage.getLoginPage();
        // Ð—Ð°Ñ…Ð¾Ð´Ð¸Ð¼ Ð½Ð° Ñ„Ð¾Ñ€ÑƒÐ¼
        MainPageLoggedIn dashboard = loginPage.login("LM", "12345678");
        // ÐŸÐ¾Ð´Ñ‚Ð²ÐµÑ€Ð¶Ð´Ð°ÐµÐ¼ Ñ‡Ñ‚Ð¾ Ð²Ñ…Ð¾Ð´ Ð¾Ñ�ÑƒÑ‰ÐµÑ�Ñ‚Ð²Ð»ÐµÐ½
        this.assertSuccess(dashboard, "Login");
        // Ð’Ñ‹Ð²Ð¾Ð´Ð¸Ð¼ Ð² ÐºÐ¾Ð½Ñ�Ð¾Ð»ÑŒ Ð¸Ð¼Ñ� Ð¿Ð¾Ð»ÑŒÐ·Ð¾Ð²Ð°Ñ‚ÐµÐ»Ñ� Ð½Ð° Ñ„Ð¾Ñ€ÑƒÐ¼Ðµ
        System.out.println("Name: " + dashboard.getUsername());

        TopicPage topic = dashboard.openQAAutomation().openTopic();
        topic.printAllAuthors();
        topic.openUsers().printUsers();


        // Ð–Ð´Ñ‘Ð¼ 10 Ñ�ÐµÐº, Ñ� Ð¿ÐµÑ€ÐµÑ…Ð²Ð°Ñ‚Ð¾Ð¼ Ð¸Ñ�ÐºÐ»ÑŽÑ‡ÐµÐ½Ð¸Ñ� Ð½Ð° Ð¿Ñ€ÐµÑ€Ñ‹Ð²Ð°Ð½Ð¸Ðµ Ð²Ñ‹Ð¿Ð¾Ð»Ð½ÐµÐ½Ð¸Ñ� Ð¿Ð¾Ñ‚Ð¾ÐºÐ° Ð¸ Ð¸Ð³Ð½Ð¾Ñ€Ð¸Ñ€ÑƒÐµÐ¼ ÐµÐ³Ð¾
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) { /* Ð˜Ð³Ð½Ð¾Ñ€Ð¸Ñ€ÑƒÐµÐ¼ */ }

    }

    @Override
    public void afterTest()
    {
        // Ð’Ñ‹Ð²Ð¾Ð´ Ð² ÐºÐ¾Ð½Ñ�Ð¾Ð»ÑŒ
        System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
    }
}
